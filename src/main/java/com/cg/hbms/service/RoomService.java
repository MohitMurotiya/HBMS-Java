package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Room;
import com.cg.hbms.model.User;

public interface RoomService {
	List<Room> findAll() throws HotelManagementException;

	Room findById(int roomId) throws HotelManagementException;

	int add(Room room) throws HotelManagementException;

	boolean update(Room room) throws HotelManagementException;
	
	Room validateRoomId(int roomId);
}
