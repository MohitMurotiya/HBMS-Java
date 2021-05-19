package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;


public interface HotelService {

	List<Hotel> findAll() throws HotelManagementException;

	Hotel findById(int hotelId) throws HotelManagementException;

	int add(Hotel hotel) throws HotelManagementException;

	boolean update(Hotel hotel) throws HotelManagementException;
	
	//List<Hotel> findAllByRoomType(RType T) throws HotelException;
	
	Hotel validateHotelId(int hotelId) throws HotelManagementException;
}
