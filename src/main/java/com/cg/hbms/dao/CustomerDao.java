package com.cg.hbms.dao;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Customer;
import com.cg.hbms.model.Hotel;

public interface CustomerDao {

	Customer add(Customer customer) throws HotelManagementException;

	List<Customer> findAll() throws HotelManagementException;

	Customer findByUserId(int userId) throws HotelManagementException;

	boolean update(Customer customer) throws HotelManagementException;

	boolean deleteById(int userId, String password) throws HotelManagementException;
	
	Customer validateCustomerId(int custId);
}
