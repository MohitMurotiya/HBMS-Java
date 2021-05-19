package com.cg.hbms.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.cg.hbms.model.BookingDetails;
import com.cg.hbms.model.Customer;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.model.Room;
import com.cg.hbms.model.User;

// This is a singleton class, after implementing serializable
public class Store implements Serializable {

	private Map<Integer, User> users;
	private Map<Integer, Customer> customers;
	private Map<Integer, Hotel> hotels;
	private Map<Integer, Room> room;
	private Map<Integer, BookingDetails> bookingDetails;

	private static Store store;

	public static final String STORE_PATH = "hotel_management.dat";

	// NO one create an object of Store because of private constructor
	private Store() {

		users = new HashMap<Integer, User>();
		customers = new HashMap<Integer, Customer>();
		hotels = new HashMap<Integer, Hotel>();
		room = new HashMap<Integer, Room>();
		bookingDetails = new HashMap<Integer, BookingDetails>();
	}

	// By calling Store.getInstance() for accesing the object of class Store
	public static synchronized Store getInstance() throws ClassNotFoundException, IOException {

		if (null == store) {
			// read the object store from the file and if the file doesn't exist then store
			// = new store and if exist deserialize the file
			File file = new File(STORE_PATH);
			if (file.exists()) {
				// FileInputStream fileOutputStream = new FileInputStream(STORE_PATH);
				// ObjectInputStream objectInputStream = new
				// ObjectInputStream(fileOutputStream);

				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(STORE_PATH));

				// store = (Store) objectInputStream.readObject();
				// This way we can avoid Class Cast Exception
				Object obj = objectInputStream.readObject();
				if (obj instanceof Store) {
					store = (Store) obj;
				}
				objectInputStream.close();
			} else
				store = new Store();
		}
		return store;
	}

	public synchronized void save() throws FileNotFoundException, IOException {
		// This method is going to write the store obj into objectOutputStream
		// Write in the file
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(STORE_PATH));
		objectOutputStream.writeObject(store);
		objectOutputStream.flush();
		objectOutputStream.close();
	}

	public Map<Integer, User> getUsers() {
		return users;
	}

	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}

	public Map<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Integer, Customer> customers) {
		this.customers = customers;
	}

	public Map<Integer, Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Map<Integer, Hotel> hotels) {
		this.hotels = hotels;
	}

	public Map<Integer, Room> getRoom() {
		return room;
	}

	public void setRoom(Map<Integer, Room> room) {
		this.room = room;
	}

	public Map<Integer, BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Map<Integer, BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

}
