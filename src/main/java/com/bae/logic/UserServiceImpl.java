package com.bae.logic;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	public UserRepository repository;

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
	public Optional<User> createUser(User user) {
		repository.save(user);
		Optional<User> userDetails = repository.findById(user.getId());
		return userDetails;
	}

	@Override
	public String deleteAUser(long id) {
		repository.deleteById(id);
		return "{\"message\": \"user has been successfully deleted\"}";
	}

}
