package com.cg.hbms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;
import com.cg.hbms.store.HotelRepository;

public class BookingDetailsDaoImpl implements BookingDetailsDao {

	private Map<Integer, BookingDetails> bookingsMap;

	public BookingDetailsDaoImpl() throws HotelManagementException {
		
		bookingsMap = HotelRepository.getBookingHashMap();
	}

	public List<BookingDetails> findAll() throws HotelManagementException {
		
		List<BookingDetails> boookingsList = new ArrayList<BookingDetails>(bookingsMap.values());
		return boookingsList;
	}

	public BookingDetails findById(int bookingId) throws HotelManagementException {
		
		return bookingsMap.get(bookingId);
	}


	public int addBookings(int bookingId, BookingDetails bookingDetails) throws HotelManagementException {
		if(null != bookingDetails) {
			bookingsMap.put(bookingDetails.getBookingId(), bookingDetails);
		}
		return 0;
	}

}
