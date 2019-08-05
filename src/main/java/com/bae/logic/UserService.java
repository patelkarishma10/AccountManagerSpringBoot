package com.bae.logic;

import java.util.Collection;

import com.bae.entity.User;

public interface UserService {

	User getAUser(long id);

	Collection<User> getAllUsers();

}
