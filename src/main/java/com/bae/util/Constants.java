package com.bae.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bae.entity.User;

@Component
public class Constants {

	public static final User MOCK_USER_OBJECT = new User(1, "user1", "user1", "£50");
	public static final User MOCK_USER_OBJECT2 = new User(2, "user2", "user2", "£500");
	public static final Optional<User> MOCK_USER_OBJECT3 = Optional.of(MOCK_USER_OBJECT);

//	String MOCK_USER_OBJECT = "{\"id\":1,\"firstname\":\"user1\",\"lastname\":\"user1\",\"prize\":\"£50\"}";
//	String MOCK_USER_OBJECT2 = "{\"id\":2,\"firstname\":\"user2\",\"lastname\":\"user2\",\"prize\":\"£500\"}";
}
