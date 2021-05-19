
package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.User;

public interface UserService {

	int add(User user) throws HotelManagementException;

	List<User> findAll() throws HotelManagementException;

	User findById(int userId) throws HotelManagementException;

	boolean update(User user) throws HotelManagementException;

	boolean deleteById(int userId) throws HotelManagementException;
	
	User login(int userId, String password) throws HotelManagementException;

	User validateEmpId(int empId);
	
	String userName = "^[a-z0-9_-]{3,15}$"; //@ is not allowed
	String password = "[7-9]{1}[0-9]{2}";
	
	static boolean validateUserName(String name) {
		return name.matches(userName);
	}
	
	static boolean validatePassword(String pass) {
		return pass.matches(password);
	}
}
