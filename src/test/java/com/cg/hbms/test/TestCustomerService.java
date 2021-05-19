package com.cg.hbms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Customer;
import com.cg.hbms.service.CustomerService;
import com.cg.hbms.service.CustomerServiceImpl;

public class TestCustomerService {

	static CustomerService testCustomerService;
	static Customer customer;
	static int userId;
	static List<Customer> customers;

	@Before
	public void testUser() throws HotelManagementException {
		testCustomerService = new CustomerServiceImpl();
	}

	/*
	 * @Test public void testUserAdd() { System.out.println(userId); assertEquals(0,
	 * userId); }
	 */

	@Test
	public void testUserFindAllUser() {
		try {
			customers = testCustomerService.findAll();
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
		assertNotNull(customers);
	}

	@Test
	public void testUserUpdate() {
		try {
			assertTrue(testCustomerService.update(customer));
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
	}
	
	/*
	 * @Test public void testUserDelete() { try {
	 * assertTrue(testCustomerService.deleteByUserId(100001, "123")); } catch
	 * (HotelManagementException exp) { exp.printStackTrace(); } }
	 */


}
