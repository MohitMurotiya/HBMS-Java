package com.cg.hbms.store;

import java.time.LocalDate;
import java.util.HashMap;

import com.cg.hbms.model.BookingDetails;
import com.cg.hbms.model.Customer;
import com.cg.hbms.model.Gender;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.model.RType;
import com.cg.hbms.model.Role;
import com.cg.hbms.model.Room;
import com.cg.hbms.model.User;

public class HotelRepository {

	static HashMap<Integer, User> userHashMap = new HashMap<Integer, User>();
	static HashMap<Integer, Customer> customerHashMap = new HashMap<Integer, Customer>();
	static HashMap<Integer, Room> roomHashMap = new HashMap<Integer, Room>();
	static HashMap<Integer, Hotel> hotelHashMap = new HashMap<Integer, Hotel>();
	static HashMap<Integer, BookingDetails> bookingHashMap = new HashMap<Integer, BookingDetails>();

	public static void addDetails() {

		User user1 = new User(10101, "mohit", "123", Role.Customer);
		userHashMap.put(10101, user1);
		User user2 = new User(10102, "jeetu", "456", Role.Customer);
		userHashMap.put(10102, user2);
		User user3 = new User(10103, "sandeep", "789", Role.Customer);
		userHashMap.put(10103, user3);
		User user4 = new User(10104, "bablu", "321", Role.Customer);
		userHashMap.put(10104, user4);
		User user5 = new User(10105, "tinku", "654", Role.Customer);
		userHashMap.put(10105, user5);
		User user6 = new User(10106, "mahesh", "987", Role.Employee);
		userHashMap.put(10106, user6);
		User user7 = new User(10107, "ramesh", "741", Role.Employee);
		userHashMap.put(10107, user7);
		User user8 = new User(10108, "suresh", "852", Role.Employee);
		userHashMap.put(10108, user8);
		User user9 = new User(10109, "rakesh", "963", Role.Employee);
		userHashMap.put(10109, user9);
		User user10 = new User(101010, "naresh", "123", Role.Employee);
		userHashMap.put(101010, user10);

		
		Customer customer1 = new Customer(user1, "Mohit", "Murotiya", "7894561230", Gender.Male, 21, "m@m.com");
		customerHashMap.put(user1.getUserId(), customer1);
		Customer customer2 = new Customer(user2, "Jeetu", "Bhaiya", "7894561230", Gender.Male, 21, "m@m.com");
		customerHashMap.put(user2.getUserId(), customer2);
		Customer customer3 = new Customer(user3, "Sandeep", "Bhaiya", "7894561230", Gender.Male, 21, "m@m.com");
		customerHashMap.put(user3.getUserId(), customer3);
		Customer customer4 = new Customer(user4, "Bablu", "Bhaiya", "7894561230", Gender.Male, 21, "m@m.com");
		customerHashMap.put(user4.getUserId(), customer4);
		Customer customer5 = new Customer(user5, "Tinku", "Bhaiya", "7894561230", Gender.Male, 21, "m@m.com");
		customerHashMap.put(user5.getUserId(), customer5);


		Hotel hotel1 = new Hotel(500101, "Taj", "794563210", "m@g.com", "Mumbai");
		hotelHashMap.put(500101, hotel1);
		Hotel hotel2 = new Hotel(500102, "Oberoi",  "794563210", "m@g.com", "Mumbai");
		hotelHashMap.put(500102, hotel2);
		Hotel hotel3 = new Hotel(500103, "Padimini",  "794563210", "m@g.com", "COR");
		hotelHashMap.put(500103, hotel3);
		Hotel hotel4 = new Hotel(500104, "Pasha", "794563210", "m@g.com", "Pune");
		hotelHashMap.put(500104, hotel4);
		Hotel hotel5 = new Hotel(500105, "Novotel", "794563210", "m@g.com", "Pune");
		hotelHashMap.put(500105, hotel5);

		Room room1 = new Room(1101, 101, RType.AC, 5000, hotel1);
		roomHashMap.put(1101, room1);
		Room room2 = new Room(1102, 102, RType.AC, 5000, hotel1);
		roomHashMap.put(1102, room2);
		Room room3 = new Room(1103, 103, RType.AC, 5000, hotel1);
		roomHashMap.put(1103, room3);
		Room room4 = new Room(1104, 111, RType.NON_AC, 3000, hotel1);
		roomHashMap.put(1104, room4);
		Room room5 = new Room(1105, 112, RType.NON_AC, 3000, hotel1);
		roomHashMap.put(1105, room5);
		Room room6 = new Room(1106, 121, RType.DELUX , 7000, hotel1);
		roomHashMap.put(1106, room6);
		Room room7 = new Room(1107, 122, RType.DELUX, 7000, hotel1);
		roomHashMap.put(1107, room7);
		Room room8 = new Room(1103, 103, RType.NON_AC, 3000, hotel1);
		roomHashMap.put(11014, room8);
		Room room9 = new Room(1104, 101, RType.AC, 6000, hotel2);
		roomHashMap.put(11013, room9);
		Room room10 = new Room(1105, 102, RType.DELUX, 5000, hotel2);
		roomHashMap.put(11012, room10);
		Room room11 = new Room(1106, 101, RType.DELUX, 9000, hotel3);
		roomHashMap.put(11011, room11);
		
		
		BookingDetails booking1 = new BookingDetails(78901, hotel1, room1, customer1, LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 03), 2, 15000.0);
		bookingHashMap.put(78901, booking1);
		BookingDetails booking2 = new BookingDetails(78902, hotel2, room4, customer1, LocalDate.of(2020, 01, 05), LocalDate.of(2020, 01, 06), 2, 12000.0);
		bookingHashMap.put(78902, booking2);
		BookingDetails booking3 = new BookingDetails(78903, hotel2, room5, customer2, LocalDate.of(2020, 01, 10), LocalDate.of(2020, 01, 12), 2, 18000.0);
		bookingHashMap.put(78903, booking3);
		BookingDetails booking4 = new BookingDetails(78904, hotel3, room6, customer3, LocalDate.of(2020, 01, 16), LocalDate.of(2020, 01, 16), 2, 9000.0);
		bookingHashMap.put(78904, booking4);
		BookingDetails booking5 = new BookingDetails(78905, hotel3, room6, customer4, LocalDate.of(2020, 02, 13), LocalDate.of(2020, 02, 15), 2, 27000.0);
		bookingHashMap.put(78905, booking5);
	}
	
	public static HashMap<Integer, User> getUserHashMap() {
		return userHashMap;
	}
	
	public static HashMap<Integer, Customer> getCustomerHashMap(){
		return customerHashMap;
	}

	public static HashMap<Integer, Hotel> getHotelHashMap() {
		return hotelHashMap;
	}

	public static HashMap<Integer, Room> getRoomHashMap() {
		return roomHashMap;
	}
	
	public static HashMap<Integer, BookingDetails> getBookingHashMap(){
		return bookingHashMap;
	}

}