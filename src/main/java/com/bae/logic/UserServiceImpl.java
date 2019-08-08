package com.bae.logic;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.SentUser;
import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserServiceImpl(UserRepository repository, RestTemplate restTemplate, JmsTemplate jmsTemplate) {

		this.repository = repository;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}

	public UserRepository repository;

	private RestTemplate restTemplate;

	private JmsTemplate jmsTemplate;

	public UserServiceImpl() {

	}

	@Override
	public Optional<User> getAUser(long id) {
		Optional<User> user = repository.findById(id);
		return user;
	}

	@Override
	public Collection<User> getAllUsers() {
		Collection<User> newList = repository.findAll();
		return newList;
	}

	@Override
	public User createUser(User user) {
		String accountNumber = restTemplate.getForObject("http://numgen:8089/user/getAccountNumber", String.class);
		user.setAccountNumber(accountNumber);

		String accountNumberToSend = accountNumber;
		ResponseEntity<String> prize = restTemplate.exchange(
				"http://prizegen:8088/user/getPrize/" + accountNumberToSend, HttpMethod.GET, null, String.class);
		user.setPrize(prize.getBody());

		sendToQueue(user);
		return repository.save(user);

	}

	@Override
	public String deleteAUser(long id) {
		repository.deleteById(id);
		return "{\"message\": \"user has been successfully deleted\"}";
	}

	private void sendToQueue(User user) {
		SentUser accountToStore = new SentUser(user);
		jmsTemplate.convertAndSend("AccountQueue", accountToStore);
	}

}
