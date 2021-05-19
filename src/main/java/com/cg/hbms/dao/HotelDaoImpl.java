package com.cg.hbms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.store.HotelRepository;

public class HotelDaoImpl implements HotelDao {

	private Map<Integer, Hotel> hotelsMap;

	public HotelDaoImpl() throws HotelManagementException {

		hotelsMap = HotelRepository.getHotelHashMap();
		
	}

	public int add(int hotelId, Hotel hotel) throws HotelManagementException {
		if (null != hotel) {
			hotelsMap.put(hotelId, hotel);
		}
		return 0;
	}

	public List<Hotel> findAll() throws HotelManagementException {

		List<Hotel> hotelsList = new ArrayList<Hotel>(hotelsMap.values());
		return hotelsList;
	}

	public Hotel findById(int hotelId) throws HotelManagementException {

		return hotelsMap.get(hotelId);
	}

	public boolean update(Hotel hotel) throws HotelManagementException {

		if (null != hotel) {
			hotelsMap.replace(hotel.getHotelId(), hotel);
		}
		return true;
	}

	@Override
	public Hotel validateHotelId(int hotelId) {
		
		return hotelsMap.get(hotelId);
	}

}
