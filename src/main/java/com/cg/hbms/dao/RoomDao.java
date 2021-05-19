package com.cg.hbms.dao;

import java.util.List;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Room;

public interface RoomDao {

	int add(int roomId, Room roomDetails) throws HotelManagementException;

	List<Room> findAll() throws HotelManagementException;

	Room findById(int roomId) throws HotelManagementException;
	
	boolean update(Room room) throws HotelManagementException;

	Room validateRoomId(int roomId);

}
