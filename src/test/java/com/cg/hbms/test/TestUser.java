package com.cg.hbms.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Role;
import com.cg.hbms.model.User;
import com.cg.hbms.service.UserService;
import com.cg.hbms.service.UserServiceImpl;

public class TestUser {

	static UserService testUserService;
	static User user;
	static int userId;
	static List<User> users;

	@Before
	public void testUser() throws HotelManagementException {
		testUserService = new UserServiceImpl();
		user = new User(100003, "abhi", "abhi", Role.Employee);
		userId = testUserService.add(user);
		users = testUserService.findAll();
	}
	
	@After
	public void close() {
		testUserService = null;
	}

//	@Test
//	public void testUserAdd() {
//		System.out.println(userId);
//		assertEquals(100003, userId);
//	}

	@Test
	public void testUserFindAllUser() {
		try {
			users = testUserService.findAll();
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
		assertNotNull(users);
	}

	@Test
	public void testUserUpdate() {
		try {
			assertTrue(testUserService.update(user));
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
	}
	
	@Test
	public void testUserDelete() {
		try {
			assertTrue(testUserService.deleteById(userId));
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
	}


}
