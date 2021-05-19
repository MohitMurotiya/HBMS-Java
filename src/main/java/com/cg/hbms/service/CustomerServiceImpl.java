package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.dao.CustomerDao;
import com.cg.hbms.dao.CustomerDaoImpl;
import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl() throws HotelManagementException {
		
		customerDao = new CustomerDaoImpl();
		
	}

	@Override
	public List<Customer> findAll() throws HotelManagementException {
		return customerDao.findAll();
	}

	@Override
	public Customer findByUserId(int userId) throws HotelManagementException {
		return customerDao.findByUserId(userId);
	}

	@Override
	public Customer add(Customer customer) throws HotelManagementException {
		return customerDao.add(customer);
	}

	@Override
	public boolean update(Customer customer) throws HotelManagementException {
		return customerDao.update(customer);
	}

	@Override
	public boolean deleteByUserId(int userId, String password) throws HotelManagementException {
	
		return customerDao.deleteById(userId, password);
	}

	@Override
	public Customer validateCustomerId(int custId) {
		return customerDao.validateCustomerId(custId);
	}

}
