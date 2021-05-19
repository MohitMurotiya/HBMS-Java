package com.cg.hbms.service;

import java.util.List;
import java.util.Set;

import com.cg.hbms.dao.HotelDao;
import com.cg.hbms.dao.HotelDaoImpl;
import com.cg.hbms.dao.RoomDao;
import com.cg.hbms.dao.RoomDaoImpl;
import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.model.Room;

public class RoomServiceImpl implements RoomService {
	
	private RoomDao dao;
	private HotelDao hotelDao;
	
	public RoomServiceImpl() throws HotelManagementException {
		dao = new RoomDaoImpl();
		hotelDao = new HotelDaoImpl();
	}

	public List<Room> findAll() throws HotelManagementException {

		return dao.findAll();
	}

	public Room findById(int roomId) throws HotelManagementException {
		return dao.findById(roomId);
	}

	private final int generateRoomId() throws HotelManagementException {
		if(dao.findAll().size()==0)
			return 1101;
		
		int maxId = dao.findAll().stream().map((id) -> id.getRoomId()).max(Integer :: compare).get();
		return ++maxId;
	}
	
	public int add(Room room) throws HotelManagementException {
		int roomId = generateRoomId();
		room.setRoomId(roomId);
		dao.add(roomId, room);
		
		Hotel hotel = room.getHotel();
		Set<Room> roomSet = hotel.getRooms();
		roomSet.add(room);
		hotelDao.findById(hotel.getHotelId()).setRooms(roomSet);
		return roomId;
	}

	public boolean update(Room room) throws HotelManagementException {
		return dao.update(room);
	}

	@Override
	public Room validateRoomId(int roomId) {

		return dao.validateRoomId(roomId);
	}

}
