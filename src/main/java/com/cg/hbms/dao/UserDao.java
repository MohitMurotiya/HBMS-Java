package com.cg.hbms.dao;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.User;

public interface UserDao {

	int add(int userId, User user) throws HotelManagementException;
	
	List<User> findAll() throws HotelManagementException;
	
	User findById(int userId) throws HotelManagementException;
	
	boolean update(User user) throws HotelManagementException;
	
	boolean deleteById(int userId) throws HotelManagementException;
	
	User login(int userId, String password) throws HotelManagementException;

	User validateUserId(int empId);
}
