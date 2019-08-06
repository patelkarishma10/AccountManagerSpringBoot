package com.bae.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.entity.User;
import com.bae.logic.UserService;
import com.bae.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	UserController controller;

	@Mock
	UserService service;

	@Test
	public void getAllUsersTest() {
		List<User> MOCK_USER_ARRAY = new ArrayList<>();
		MOCK_USER_ARRAY.add(Constants.MOCK_USER_OBJECT);
		MOCK_USER_ARRAY.add(Constants.MOCK_USER_OBJECT2);
		Mockito.when(service.getAllUsers()).thenReturn(MOCK_USER_ARRAY);
		assertEquals(MOCK_USER_ARRAY, controller.getAllUsers());
		Mockito.verify(service).getAllUsers();
	}

	@Test
	public void getAUserTest() {
		Mockito.when(service.getAUser((long) 3)).thenReturn(Constants.MOCK_USER_OBJECT3);
		assertEquals(Constants.MOCK_USER_OBJECT3, controller.getAUser((long) 3));
		Mockito.verify(service).getAUser((long) 3);
	}

	@Test
	public void createUserTest() {
		Mockito.when(service.createUser(Constants.MOCK_USER_OBJECT)).thenReturn(Constants.MOCK_USER_OBJECT);
		assertEquals(Constants.MOCK_USER_OBJECT, controller.createUser(Constants.MOCK_USER_OBJECT));
		Mockito.verify(service).createUser(Constants.MOCK_USER_OBJECT);
	}

}
