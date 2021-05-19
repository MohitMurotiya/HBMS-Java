package com.cg.hbms.model;

import java.time.LocalDate;

/**
 * 
 * @author MM
 *
 */
public class BookingDetails {

	private int bookingId;
	private Hotel hotel;
	private Room room;
	private Customer customer;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numOfGuests;
	private double finalPrice;

	public BookingDetails() {

	}

	public BookingDetails(int bookingId, Hotel hotel, Room room, Customer customer, LocalDate checkIn,
			LocalDate checkOut, int numOfGuests, double finalPrice) {
		super();
		this.bookingId = bookingId;
		this.hotel = hotel;
		this.room = room;
		this.customer = customer;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numOfGuests = numOfGuests;
		this.finalPrice = finalPrice;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumOfGuests() {
		return numOfGuests;
	}

	public void setNumOfGuests(int num_of_guests) {
		this.numOfGuests = num_of_guests;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return " BOOKING DETAILS OF : " + bookingId + "\n Hotel Details : " + hotel
				+ "\n Room Details : " + room + "\n Customer Details : " + customer + "\n Check-In : " + checkIn
				+ ", Check-Out : " + checkOut + ", Number of Guests=" + numOfGuests + "\n Final Price : " + finalPrice
				+ "\n";
	}

}
