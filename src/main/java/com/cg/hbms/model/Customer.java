package com.cg.hbms.model;
/**
 * 
 * @author MM
 *
 */
public class Customer {

	private User user;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Gender gender;
	private int age;
	private String email;

	public Customer() {
		
	}

	public Customer(User user, String firstName, String lastName, String phoneNumber, Gender gender, int age,
			String email) {
		super();
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.age = age;
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer Id : "+user.getUserId() +"FirstName : " + firstName + ", LastName : " + lastName + ", Phone Number : "
				+ phoneNumber + ", Gender : " + gender + ", Age : " + age + ", Email : " + email;
	}

}
