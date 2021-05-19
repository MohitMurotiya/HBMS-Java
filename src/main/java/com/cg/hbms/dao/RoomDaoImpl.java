package com.cg.hbms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Room;
import com.cg.hbms.store.HotelRepository;

public class RoomDaoImpl implements RoomDao {

	private Map<Integer, Room> roomsMap;
	

	public RoomDaoImpl() throws HotelManagementException {
		
		roomsMap = HotelRepository.getRoomHashMap();

	}

	public int add(int roomId, Room room) throws HotelManagementException {
		if (null != room) {
			roomsMap.put(roomId, room);
		
		}
		return 0;
	}

	public List<Room> findAll() throws HotelManagementException {
		List<Room> roomsList = new ArrayList<Room>(roomsMap.values());
		return roomsList;
	}

	public Room findById(int roomId) throws HotelManagementException {
		return roomsMap.get(roomId);
	}

	

	public boolean update(Room room) throws HotelManagementException {
		if (null != room) {
			roomsMap.put(room.getRoomId(), room);
		
		}
		return true;

	}

	@Override
	public Room validateRoomId(int roomId) {
		
		return roomsMap.get(roomId);
	}
}
