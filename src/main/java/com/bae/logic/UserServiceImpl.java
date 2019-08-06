package com.bae.logic;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

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
	public User createUser(User user) {
		// Optional<User> userDetails = repository.findById(user.getId());
		Random random = new Random();
		int numgen = random.nextInt(3);
		if (numgen == 0) {
			int num = random.nextInt(100000) + 1000000;
			user.setPrize("£50");
		} else if (numgen == 1) {
			int num = random.nextInt(1000000) + 10000000;
			user.setPrize("£500");
		} else {
			int num = random.nextInt(10000000) + 100000000;
			user.setPrize("£5000");
		}

		return repository.save(user);

	}

	@Override
	public String deleteAUser(long id) {
		repository.deleteById(id);
		return "{\"message\": \"user has been successfully deleted\"}";
	}

}
