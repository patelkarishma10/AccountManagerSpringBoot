package com.bae.logic;

import java.util.Collection;

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
	public User getAUser(long id) {
		User user = repository.getOne(id);
		return user;
	}

	@Override
	public Collection<User> getAllUsers() {
		Collection<User> newList = repository.findAll();
		return newList;
	}

}
