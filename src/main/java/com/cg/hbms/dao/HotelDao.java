package com.cg.hbms.dao;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;

public interface HotelDao {

	int add(int hotelId, Hotel hotel) throws HotelManagementException;

	List<Hotel> findAll() throws HotelManagementException;

	Hotel findById(int hotelId) throws HotelManagementException;

	boolean update(Hotel hotel) throws HotelManagementException;

	Hotel validateHotelId(int hotelId);
}
