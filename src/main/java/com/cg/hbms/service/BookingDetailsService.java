package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;

public interface BookingDetailsService {

	List<BookingDetails> findAll() throws HotelManagementException;

	int addBookings(BookingDetails bookingDetails) throws HotelManagementException;

	BookingDetails findById(int bookingId) throws HotelManagementException;

	//List<BookingDetails> findByDate(Hotel hotel, LocalDate bookingFrom, LocalDate bookingTill) throws HotelManagementException;

	//List<BookingDetails> findByHotel(int hotelId) throws HotelManagementException;

	List<BookingDetails> findByCustomer(int userId) throws HotelManagementException;
}
