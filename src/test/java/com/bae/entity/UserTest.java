package com.bae.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void userTest() {
		User user1 = new User(1, "user1", "user1", "£50");

		user1.setId(2);
		user1.setFirstname("testFirstname");
		user1.setLastname("TestLastname");
		user1.setPrize("testPrize");

		assertEquals(2, user1.getId());
		assertEquals("testFirstname", user1.getFirstname());
		assertEquals("TestLastname", user1.getLastname());
		assertEquals("testPrize", user1.getPrize());
	}

}
