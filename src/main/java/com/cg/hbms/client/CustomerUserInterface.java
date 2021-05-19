package com.cg.hbms.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;
import com.cg.hbms.model.Customer;
import com.cg.hbms.model.Gender;
import com.cg.hbms.model.Hotel;
import com.cg.hbms.model.RType;
import com.cg.hbms.model.Role;
import com.cg.hbms.model.Room;
import com.cg.hbms.model.User;
import com.cg.hbms.service.BookingDetailsService;
import com.cg.hbms.service.BookingDetailsServiceImpl;
import com.cg.hbms.service.CustomerService;
import com.cg.hbms.service.CustomerServiceImpl;
import com.cg.hbms.service.HotelService;
import com.cg.hbms.service.HotelServiceImpl;
import com.cg.hbms.service.RoomService;
import com.cg.hbms.service.RoomServiceImpl;
import com.cg.hbms.service.UserService;
import com.cg.hbms.service.UserServiceImpl;

public class CustomerUserInterface {

	private static CustomerService customerService;
	private static UserService userService;
	private static HotelService hotelService;
	private static RoomService roomService;
	private static BookingDetailsService bookingService;

	static {
		try {
			customerService = new CustomerServiceImpl();
			userService = new UserServiceImpl();
			hotelService = new HotelServiceImpl();
			roomService = new RoomServiceImpl();
			bookingService = new BookingDetailsServiceImpl();
		} catch (HotelManagementException e) {
			e.printStackTrace();
		}
	}

	public static void customerRegistration() throws HotelManagementException {

		Customer customer = new Customer();
		User user = new User();

		Client.scanner.nextLine();
		System.out.println("Enter Your First Name : ");
		customer.setFirstName(Client.scanner.nextLine());

		System.out.println("Enter Your Last Name : ");
		customer.setLastName(Client.scanner.nextLine());

		while (true) {
			System.out.println("Enter Your Number : ");
			String number = Client.scanner.nextLine();

			if (CustomerService.validateNumberPattern(number)) {
				customer.setPhoneNumber(number);
				break;
			} else
				System.out.println("Invalid format");
		}

		int genderIndex = -2;

		System.out.println("GIndex\tGender");
		for (Gender gen : Gender.values()) {
			System.out.println(gen.ordinal() + "\t" + gen);
		}

		System.out.println("Select Gender : ");

		genderIndex = Client.scanner.nextInt();
		if (genderIndex >= Gender.values().length) {
			System.out.println("Invalid Choice");
		} else if (genderIndex != -1) {

			customer.setGender(Gender.values()[genderIndex]);
		}

		while (true) {
			System.out.println("Enter your Age : ");
			int age = Client.scanner.nextInt();

			if (CustomerService.validateAge(age)) {
				customer.setAge(age);
				break;
			} else
				System.out.println("Age should be greater than 18");
		}

		Client.scanner.nextLine();

		while (true) {
			System.out.println("Enter your email : ");
			String email = Client.scanner.nextLine();

			if (CustomerService.validateEmailPattern(email)) {
				customer.setEmail(email);
				break;
			} else
				System.out.println("Invalid format");
		}

		while (true) {
			System.out.println("Enter username : ");
			String username = Client.scanner.nextLine();

			if (CustomerService.validateUserName(username)) {
				user.setUserName(username);
				break;
			} else
				System.out.println("Invalid format");
		}

		while (true) {
			System.out.println("Enter password : ");
			String pass = Client.scanner.nextLine();

			if (CustomerService.validatePassword(pass)) {
				user.setPassword(pass);
				break;
			} else
				System.out.println("Invalid format");
		}

		user.setRole(Role.Customer);

		int userId = userService.add(user);

		customer.setUser(user);
		customerService.add(customer);
		System.out.println("Customer is added with id : " + userId);
	}

	public static void customerLogin() throws HotelManagementException {

		User user = null;
		System.out.println("Enter user Id : ");

		try {
			int userId = Client.scanner.nextInt();
			user = userService.validateEmpId(userId);
			if (user == null) {
				throw new HotelManagementException();
			} else
				Client.scanner.nextLine();
			System.out.println("Enter password : ");
			String pass = Client.scanner.nextLine();

			user = userService.login(userId, pass);

			if (user.getUserId() == userId && user.getPassword().equals(pass)) {
				System.out.println("Logged in Successfully ...!!");
				showMainMenu(user);
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Customer Id did not Match");
		}

	}

	public static void showMainMenu(User user) throws HotelManagementException {

		int choice = 0;
		while (true) {

			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| 						CUSTOMER 		             |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. View List of Hotels");
			System.out.println("2. Book Room");
			System.out.println("3. Delete Account");
			System.out.println("4. View Hotels By City");
			System.out.println("5. Log Out");
			try {
				choice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}

			switch (choice) {
			case 1:
				listOfHotels();
				break;
			case 2:
				bookRoom(user);
				break;
			case 3:
				deleteAccount();
				break;
			case 4:
				viewHotelsByCity();
				break;
			case 5:
				Client.showMainMenu();
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	private static void viewHotelsByCity() throws HotelManagementException {

		int choice = 0;

		System.out.println("1. Mumbai");
		System.out.println("2. Pune");
		System.out.println("3. COR");

		try {
			choice = Client.scanner.nextInt();
		} catch (InputMismatchException exp) {
			Client.scanner.hasNext();
		}

		switch (choice) {
		case 1:
			hotelService.findAll().stream().filter((hotel) -> hotel.getCity().equals("Mumbai"))
					.forEach(System.out::println);
			break;
		case 2:
			hotelService.findAll().stream().filter((hotel) -> hotel.getCity().equals("Pune"))
					.forEach(System.out::println);
			break;
		case 3:
			hotelService.findAll().stream().filter((hotel) -> hotel.getCity().equals("COR"))
					.forEach(System.out::println);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private static void bookRoom(User user) throws HotelManagementException {
		Room room = new Room();
		BookingDetails bookDetail = new BookingDetails();

		Customer customer = customerService.validateCustomerId(user.getUserId());
		if (customer == null) {
			System.out.println("User doesn't exist");
		} else {

			System.out.println("Enter Hotel Id : ");

			try {
				int hotelId = Client.scanner.nextInt();
				Hotel hotel = hotelService.validateHotelId(hotelId);
				if (hotel == null) {
					throw new HotelManagementException();
				} else {

					Client.scanner.nextLine();
					int rTypeIndex = -2;

					System.out.println("RTIndex\tRoomType");
					for (RType rt : RType.values()) {
						System.out.println(rt.ordinal() + "\t" + rt);
					}

					System.out.println("Select a room type index : ");

					rTypeIndex = Client.scanner.nextInt();
					if (rTypeIndex >= RType.values().length) {
						System.out.println("Invalid Choice");
					} else if (rTypeIndex != -1) {

						RType type = RType.values()[rTypeIndex];
						room.setrType(type);

						List<Room> list = roomService.findAll().stream()
								.filter((roomType) -> roomType.getHotel().getHotelId() == hotelId
										&& roomType.getrType().equals(type) && !roomType.getAvailability())
								.collect(Collectors.toList());
						for (Room room1 : list)
							System.out.println(room1);
					}

					Room room1 = null;

					System.out.println("Enter Room Id : ");

					try {
						int roomId = Client.scanner.nextInt();
						room1 = roomService.validateRoomId(roomId);
						if (room1 == null) {
							throw new HotelManagementException();
						} else {
							System.out.println("Room " + roomId + "selected");
						}

						System.out.println("Number of Guests : ");
						bookDetail.setNumOfGuests(Client.scanner.nextInt());

						System.out.println("For how many days you want to stay:");
						int days = Client.scanner.nextInt();
						LocalDate checkOut = parseDate(days);

						double amount = bill(room1.getPrice(), days);
						System.out.println("Your bill amount is : " + amount);

						Client.scanner.nextLine();
						System.out.println("Are You Sure you want to book a Room (Y/N) : ");
						String choice = Client.scanner.nextLine();

						while (choice.equals("y") || choice.equals("Y")) {
							bookDetail.setHotel(hotel);
							bookDetail.setCustomer(customer);
							bookDetail.setRoom(room1);
							bookDetail.setCheckIn(LocalDate.now());
							bookDetail.setCheckOut(checkOut);
							bookDetail.setFinalPrice(amount);

							int bookingId = bookingService.addBookings(bookDetail);
							System.out.println("Here is your booking Id : " + bookingId);
							System.out.println(bookDetail.toString());
							System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
							System.out.println("| 			ENJOY OUR HOSPITALITY  		             |");
							System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");

							showMainMenu(user);
						}

					} catch (HotelManagementException | InputMismatchException exp) {
						System.out.println("Room Id doesn't Exist");
					}
				}
			} catch (HotelManagementException | InputMismatchException exp) {
				System.out.println("Hotel Id doesn't Exist");
			}
		}
	}

	private static LocalDate parseDate(int days) {

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now();
		LocalDate checkOut = currentDate.plusDays(days);
		return checkOut;
	}

	private static double bill(double roomPrice, int days) {

		double amount = roomPrice * days;
		return amount;

	}

	private static void listOfHotels() throws HotelManagementException {

		System.out.println("This is the whole list of Hotels : ");

		hotelService.findAll().forEach(System.out::println);
	}

	private static void deleteAccount() throws HotelManagementException {

		Customer customer = null;
		System.out.println("Enter your Customer Id for deleting Account : ");

		try {
			int custId = Client.scanner.nextInt();
			customer = customerService.validateCustomerId(custId);
			if (customer == null) {
				throw new HotelManagementException();
			} else {
				Client.scanner.nextLine();
				System.out.println("Enter your password : ");
				String pass = Client.scanner.nextLine();

				if (customerService.deleteByUserId(custId, pass)) {
					System.out.println("Your account has been deleted");
				}
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Invalid Customer Id");
		}
	}
}
