package com.cg.hbms.service;

import java.util.List;

import com.cg.hbms.dao.HotelDao;
import com.cg.hbms.dao.HotelDaoImpl;
import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;

public class HotelServiceImpl implements HotelService {

	private HotelDao dao;
	

	public HotelServiceImpl() throws HotelManagementException {
		dao = new HotelDaoImpl();
	}

	@Override
	public List<Hotel> findAll() throws HotelManagementException {

		return dao.findAll();
	}

	@Override
	public Hotel findById(int hotelId) throws HotelManagementException {
		return dao.findById(hotelId);
	}

	private final int generateHotelId() throws HotelManagementException {
		if(dao.findAll().size()==0)
			return 500101;
		
		int maxId = dao.findAll().stream().map((id) -> id.getHotelId()).max(Integer :: compare).get();
		return ++maxId;
	}
	
	@Override
	public int add(Hotel hotel) throws HotelManagementException {
		int hotelId = generateHotelId();
		hotel.setHotelId(hotelId);
		dao.add(hotelId, hotel);
		return hotelId;
	}

	@Override
	public boolean update(Hotel hotel) throws HotelManagementException {

		return dao.update(hotel);
	}

	@Override
	public Hotel validateHotelId(int hotelId) throws HotelManagementException {

		Hotel hotel = dao.validateHotelId(hotelId);
 		if(hotel == null) {
 			throw new HotelManagementException("");
 		}else {
 			return hotel;
 		} 
	}

	/*
	 * @Override public List<Hotel> findAllByRoomType(RType rType) throws
	 * HotelException {
	 * 
	 * List<Hotel> typeList = hotelDao.findAll().stream().filter((types) ->
	 * types.getRoomType().equals(rType)).collect(Collectors.toList()); return
	 * typeList; }
	 */

}
