package com.cg.hbms.model;

/**
 * 
 * @author MM
 *
 */
public class Room {

	private int roomId;
	private int roomNum;
	private boolean availability;
	private RType rType;
	private double price;
	private Hotel hotel;

	public Room() {
		this.availability = false;
	}
	
	
	public Room(int roomId, RType rType, double price) {
		super();
		this.roomId = roomId;
		this.rType = rType;
		this.price = price;
	}

	public Room(int roomId, int roomNum, RType rType, double price, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomNum = roomNum;
		this.rType = rType;
		this.price = price;
		this.hotel = hotel;
		this.availability = false;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public RType getrType() {
		return rType;
	}

	public void setrType(RType rType) {
		this.rType = rType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Room Id : " + roomId + ", Room Number : " + roomNum + ", Room Type : " + rType;
	}

}
