package com.cg.hbms.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Customer;
import com.cg.hbms.store.HotelRepository;

public class CustomerDaoImpl implements CustomerDao {

	private Map<Integer, Customer> customersMap;

	public CustomerDaoImpl() throws HotelManagementException {
		
		customersMap = HotelRepository.getCustomerHashMap();
	}

	public Customer add(Customer customer) throws HotelManagementException {
		if (null != customer) {
			customersMap.put(customer.getUser().getUserId(), customer);
		}
		return customer;
	}

	public List<Customer> findAll() throws HotelManagementException {
		List<Customer> customersList = new ArrayList<Customer>(customersMap.values());
		return customersList;
	}

	public Customer findByUserId(int userId) throws HotelManagementException {

		return customersMap.get(userId);
	}

	public boolean update(Customer customer) throws HotelManagementException {
		if (null == customer) {
			customersMap.replace(customer.getUser().getUserId(), customer);
		}
		return true;
	}

	public boolean deleteById(int custId, String password) throws HotelManagementException {

		Customer customer = customersMap.remove(custId);
		return customer != null ? true : false;
	}

	@Override
	public Customer validateCustomerId(int custId) {

		return customersMap.get(custId);
	}


}
