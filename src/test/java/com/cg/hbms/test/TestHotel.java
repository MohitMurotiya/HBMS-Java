package com.cg.hbms.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.service.HotelService;
import com.cg.hbms.service.HotelServiceImpl;

public class TestHotel {

	static HotelService testHotelService;
	static Hotel hotel;
	static int hotelId;
	static List<Hotel> hotels;

	@Before
	public void testUser() throws HotelManagementException {
		testHotelService = new HotelServiceImpl();
		hotel = new Hotel(500101, "Hyatt", "7895612305", "abc@bca.com", "pune");
		hotelId = testHotelService.add(hotel);
		hotels = testHotelService.findAll();
	}

//	@Test
//	public void testHotelAdd() {
//		System.out.println(hotelId);
//		assertEquals(500101, hotelId);
//	}

	@Test
	public void testUserFindAllHotels() {
		try {
			testHotelService = new HotelServiceImpl();
			hotel = new Hotel(0, "Hyatt", "7895612305", "abc@bca.com", "pune");
			hotelId = testHotelService.add(hotel);
			hotels = testHotelService.findAll();
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
		assertNotNull(hotels);
	}

	@Test
	public void testHotelUpdate() {
		try {
			testHotelService = new HotelServiceImpl();
			hotel = new Hotel(0, "Hyatt", "7895612305", "abc@bca.com", "pune");
			hotelId = testHotelService.add(hotel);
			assertTrue(testHotelService.update(hotel));
		} catch (HotelManagementException exp) {
			exp.printStackTrace();
		}
	}


}
