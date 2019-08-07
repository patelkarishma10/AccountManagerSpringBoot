package com.bae.logic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.entity.User;
import com.bae.repository.UserRepository;
import com.bae.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl service;

	@Mock
	UserRepository repository;

	@Test
	public void getAllUsersTest() {
		List<User> MOCK_USER_ARRAY = new ArrayList<>();
		MOCK_USER_ARRAY.add(Constants.MOCK_USER_OBJECT);
		MOCK_USER_ARRAY.add(Constants.MOCK_USER_OBJECT2);
		Mockito.when(repository.findAll()).thenReturn(MOCK_USER_ARRAY);
		assertEquals(MOCK_USER_ARRAY, service.getAllUsers());
		Mockito.verify(repository).findAll();
	}

	@Test
	public void getAUserTest() {
		Mockito.when(repository.findById((long) 3)).thenReturn(Constants.MOCK_USER_OBJECT3);
		assertEquals(Constants.MOCK_USER_OBJECT3, service.getAUser(3));
		Mockito.verify(repository).findById((long) 3);
	}

	@Ignore
	@Test
	public void createUserTest() {
		Mockito.when(repository.save(Constants.MOCK_USER_OBJECT)).thenReturn(Constants.MOCK_USER_OBJECT);
		assertEquals(Constants.MOCK_USER_OBJECT, service.createUser(Constants.MOCK_USER_OBJECT));
		Mockito.verify(repository).save(Constants.MOCK_USER_OBJECT);
	}
}
