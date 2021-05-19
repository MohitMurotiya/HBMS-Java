package com.cg.hbms.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cg.hbms.dao.BookingDetailsDao;
import com.cg.hbms.dao.BookingDetailsDaoImpl;
import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;

public class BookingDetailsServiceImpl implements BookingDetailsService {
	private BookingDetailsDao dao;

	public BookingDetailsServiceImpl() throws HotelManagementException {
		dao = new BookingDetailsDaoImpl();
	}

	@Override
	public List<BookingDetails> findByCustomer(int userId) throws HotelManagementException {
		return dao.findAll().stream().filter(bookings -> bookings.getCustomer().getUser().getUserId()==userId)
				.collect(Collectors.toList());
	}


	@Override
	public List<BookingDetails> findAll() throws HotelManagementException {
		return dao.findAll();
	}

	@Override
	public BookingDetails findById(int bookingId) throws HotelManagementException {
		return dao.findById(bookingId);
	}

	private final int generateBookingId() throws HotelManagementException {
		if(dao.findAll().size()==0)
			return 78901;
		
		int maxId = dao.findAll().stream().map((id) -> id.getBookingId()).max(Integer :: compare).get();
		return ++maxId;
	}
	
	
	@Override
	public int addBookings(BookingDetails booking) throws HotelManagementException {
		
		int bookingId = generateBookingId();
		booking.setBookingId(bookingId);
		dao.addBookings(bookingId, booking);
		booking.getRoom().setAvailability(true);
		return bookingId;
	}


	/*
	 * @Override public List<BookingDetails> findByDate(Hotel hotel, LocalDate
	 * bookingFrom, LocalDate bookingTill) throws HotelManagementException { return
	 * bookingDetailsDao.findAll().stream() .filter(bookings ->
	 * bookings.getRoom().getRoomType().getHotel() == hotel &&
	 * bookings.getCheckIn().isAfter(bookingFrom.minusDays(1)) &&
	 * bookings.getCheckOut().isBefore(bookingTill.plusDays(1)))
	 * .collect(Collectors.toList()); }
	 */

	/*
	 * @Override public List<BookingDetails> findByHotel(int hotelId) throws
	 * HotelManagementException { // TODO Auto-generated method stub return null; }
	 */

}
