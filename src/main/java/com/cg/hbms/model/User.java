package com.cg.hbms.model;

/**
 * 
 * @author MM
 *
 */

public class User{

	private int userId;
	private String userName;
	private String password;

	private Role role;

	public User() {
		
	}

	public User(int userId, String userName, String password, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
