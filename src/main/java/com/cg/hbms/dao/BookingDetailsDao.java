package com.cg.hbms.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;

public interface BookingDetailsDao {

	List<BookingDetails> findAll() throws HotelManagementException;
	
	int addBookings(int bookingId, BookingDetails bookingDetails) throws HotelManagementException;

	BookingDetails findById(int bookingId) throws HotelManagementException;

	//List<BookingDetails> findByDate(LocalDate bookedFrom, LocalDate bookingTill) throws HotelManagementException;
}
