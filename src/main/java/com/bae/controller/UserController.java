package com.bae.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.logic.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	public UserService service;

	@GetMapping("/getOne/{id}")
	public Optional<User> getAUser(@PathVariable("id") Long id) {
		return service.getAUser(id);
	}

	@GetMapping("/getAll")
	public Collection<User> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping("/create")
	public Optional<User> createUser(@RequestBody User user) {
//		User retVal = service.createUser(user);
//		return new ResponceEntity<>(retVal, HttpStatus.OK);
		return service.createUser(user);
	}
}
