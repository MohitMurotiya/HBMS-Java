package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.dao.UserDao;
import com.cg.hbms.dao.UserDaoImpl;
import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.User;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	public UserServiceImpl() throws HotelManagementException {
		dao = new UserDaoImpl();
	}

	private final int generateUserId() throws HotelManagementException {
		if(dao.findAll().size()==0)
			return 100101;
		
		int maxId = dao.findAll().stream().map((id) -> id.getUserId()).max(Integer :: compare).get();
		return ++maxId;
	}
	

	public int add(User user) throws HotelManagementException {

		int userId = generateUserId();
		user.setUserId(userId);
		dao.add(userId, user);
		return userId;
	}

	public List<User> findAll() throws HotelManagementException {

		return dao.findAll();
	}

	public User findById(int userId) throws HotelManagementException {
		return dao.findById(userId);
		/*
		 * if(user == null) { //Throw Invalid UserId exception }
		 */
		
		
	}

	public boolean update(User user) throws HotelManagementException {

		return dao.update(user);
	}

	public boolean deleteById(int userId) throws HotelManagementException {

		return dao.deleteById(userId);
		/*
		 * if (user == null) //System.out.println("This Customer Id doesn't exist");
		 */	
	}

	public User login(int userId, String password) throws HotelManagementException {

		return dao.login(userId, password);
	}

	@Override
	public User validateEmpId(int empId) {
		return dao.validateUserId(empId);
	}

}
