package com.cg.hbms.model;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author MM
 *
 */
public class Hotel{

	private int hotelId;
	private String hotelName;
	private String contactNum;
	private String email;
	private String city;

	private Set<Room> rooms;

	public Hotel() {
		
		rooms = new HashSet<Room>();
	}

	public Hotel(int hotelId, String hotelName, String contactNum, String email, String city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.contactNum = contactNum;
		this.email = email;
		this.city = city;
		rooms = new HashSet<Room>();
	}

	public Hotel(int hotelId, String hotelName, int ratings, String contactNum, String email, Set<Room> rooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.contactNum = contactNum;
		this.email = email;
		this.rooms = rooms;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hotel Id :" + hotelId + " Hotel Name : " + hotelName;
	}

}
