package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Customer;

public interface CustomerService {

	List<Customer> findAll() throws HotelManagementException;

	Customer findByUserId(int userId) throws HotelManagementException;

	Customer add(Customer customerDetails) throws HotelManagementException;

	boolean update(Customer customerDetails) throws HotelManagementException;

	boolean deleteByUserId(int userId, String password) throws HotelManagementException;

	Customer validateCustomerId(int custId);

	String phoneNumber = "[7-9]{1}[0-9]{9}";
	String email = "^(.+)@(.+)$";
	String userName = "^[a-z0-9_-]{3,15}$";
	String password = "[7-9]{1}[0-9]{2}";

	static boolean validateUserName(String name) {
		return name.matches(userName);
	}

	static boolean validatePassword(String pass) {
		return pass.matches(password);
	}

	static boolean validateNumberPattern(String number) {
		return number.matches(phoneNumber);
	}

	static boolean validateEmailPattern(String mail) {
		return mail.matches(email);
	}
	
	static boolean validateAge(int Age) {
		
		if(Age<18) {
			return false;
		}else
			return true;
	}
}
