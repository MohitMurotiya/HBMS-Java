package com.cg.hbms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.User;
import com.cg.hbms.store.HotelRepository;
import com.cg.hbms.store.Store;

public class UserDaoImpl implements UserDao {

	private Map<Integer, User> usersMap;
	// private Store store;

	public UserDaoImpl() throws HotelManagementException {

		usersMap = HotelRepository.getUserHashMap();
		/*
		 * try { this.store=Store.getInstance(); this.usersMap = store.getUsers(); }
		 * catch (ClassNotFoundException | IOException e) { e.printStackTrace(); }
		 */
	}

	public int add(int userId, User user) throws HotelManagementException {
		if (user != null) {
			usersMap.put(userId, user);
			/*
			 * store.setUsers(usersMap); try { store.save(); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */}
		return 0;
	}

	public List<User> findAll() throws HotelManagementException {
		List<User> valueList = new ArrayList<User>(usersMap.values());
		return valueList;
	}

	public User findById(int userId) throws HotelManagementException {

		return usersMap.get(userId);
	}

	public boolean update(User user) throws HotelManagementException {
		if (user != null) {
			usersMap.replace(user.getUserId(), user);
			/*
			 * store.setUsers(usersMap); try { store.save(); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */
		}
		return true;
	}

	public boolean deleteById(int userId) throws HotelManagementException {

		User user = usersMap.remove(userId);
		/*
		 * store.setUsers(usersMap); try { store.save(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		return user != null ? true : false;
	}

	public User login(int userId, String password) throws HotelManagementException {
		User userDummy = usersMap.get(userId);
		if (userDummy.getUserId() == userId && userDummy.getPassword().equals(password)) {
			return userDummy;
		} else
			return null;
	}

	@Override
	public User validateUserId(int empId) {

		return usersMap.get(empId);
	}

}
