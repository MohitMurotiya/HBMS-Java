package com.cg.hbms.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.model.BookingDetails;
import com.cg.hbms.model.Customer;
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

public class AdminUserInterface {

	private static UserService userService;
	private static CustomerService customerService;
	private static HotelService hotelService;
	private static RoomService roomService;
	private static BookingDetailsService bookingService;

	static {
		try {
			userService = new UserServiceImpl();
			customerService = new CustomerServiceImpl();
			hotelService = new HotelServiceImpl();
			roomService = new RoomServiceImpl();
			bookingService = new BookingDetailsServiceImpl();
		} catch (HotelManagementException e) {
			e.printStackTrace();
		}
	}

	public static void showAdminMenu() throws HotelManagementException {
		int adminChoice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| ADMIN MANAGEMENT |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. Hotel Management");
			System.out.println("2. Room Management");
			System.out.println("3. Employee Management");
			System.out.println("4. Reports");
			System.out.println("5. Log Out");
			try {
				adminChoice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}

			switch (adminChoice) {
			case 1:
				showHotelManagementMenu();
				break;
			case 2:
				showRoomManagementMenu();
				break;
			case 3:
				showEmployeeManagementMenu();
				break;
			case 4:
				showCustomerManagement();
			case 5:
				Client.showMainMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}

	public static void showCustomerManagement() throws HotelManagementException {

		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| REPORTS |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. Show All Users");
			System.out.println("2. Show All Bookings");
			System.out.println("3. Show Bookings By Hotel");
			System.out.println("4. Show Bookings by date");
			System.out.println("5. Show Bookings By Customer");
			System.out.println("6. Previous Menu");

			try {
				choice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}
			switch (choice) {
			case 1:
				showAllUsers();
				break;
			case 2:
				showAllBookings();
				break;
			case 3:
				showBookingsByHotel();
				break;
			case 4:
				showBookingsByDate();
				break;
			case 5:
				showBookingsByCustomer();
				break;
			case 6:
				showAdminMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}

		}
	}

	private static void showBookingsByCustomer() throws HotelManagementException {

		Customer customer = null;
		System.out.println("Enter Customer Id : ");

		try {
			int custId = Client.scanner.nextInt();
			customer = customerService.validateCustomerId(custId);
			if (customer == null) {
				throw new HotelManagementException();
			} else {

				bookingService.findAll().stream().filter((book) -> book.getCustomer().getUser().getUserId() == custId)
						.forEach(System.out::println);
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Customer Doesn't Exist");
		}

	}

	private static void showBookingsByDate() throws HotelManagementException {
		do {
			Client.scanner.nextLine();
			System.out.println("Enter First Date (dd/MM/yyyy): ");
			LocalDate startDate = LocalDate.parse(Client.scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Enter Second Date (dd/MM/yyyy): ");
			LocalDate endDate = LocalDate.parse(Client.scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			if ((startDate.compareTo(endDate)) > 0) {
				System.out.println("Date is wrong");
			} else {
				bookingService.findAll().stream()
						.filter((book) -> book.getCheckIn().isAfter(startDate) && book.getCheckOut().isBefore(endDate))
						.forEach(System.out::println);
				break;
			}
		} while (true);
	}

	private static void showBookingsByHotel() throws HotelManagementException {

		Hotel hotel = null;
		System.out.println("Enter Hotel Id : ");

		try {
			int hotelId = Client.scanner.nextInt();
			hotel = hotelService.validateHotelId(hotelId);
			if (hotel == null) {
				throw new HotelManagementException();
			} else {
				bookingService.findAll().stream().filter((book) -> book.getHotel().getHotelId() == hotelId)
						.forEach(System.out::println);
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Hotel doesn't exist");
		}
	}

	private static void showAllBookings() throws HotelManagementException {

		System.out.println("This is the list of All Bookings ");

		List<BookingDetails> bdl = bookingService.findAll();

		for (BookingDetails book : bdl)
			System.out.println(book);
	}

	private static void showAllUsers() throws HotelManagementException {

		if (userService.findAll().isEmpty()) {
			System.out.println("No Customers are there");
		} else {
			System.out.println("This is the whole list of Users : ");

			userService.findAll().stream().filter((user) -> user.getRole() == Role.Customer)
					.forEach(System.out::println);
		}
	}

	public static void showEmployeeManagementMenu() throws HotelManagementException {
		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| EMPLOYEE MANAGEMENT |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. Add Employees");
			System.out.println("2. Delete Employees");
			System.out.println("3. Show Employess");
			System.out.println("4. Search Employee");
			System.out.println("5. Update Employee");
			System.out.println("6. Previous Menu");
			try {
				choice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}
			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				deleteEmployee();
				break;
			case 3:
				showAllEmployees();
				break;
			case 4:
				searchEmployee();
				break;
			case 5:
				updateEmployee();
				break;
			case 6:
				showAdminMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}

	private static void addEmployee() throws HotelManagementException {
		User user = new User();
		String username, password;

		Client.scanner.nextLine();

		while (true) {
			System.out.println("Provide username : ");
			username = Client.scanner.nextLine();

			if (UserService.validateUserName(username))
				break;
			else
				System.out.println("Please Enter Username in the given format only");
		}

		while (true) {
			System.out.println("Provide password : ");
			password = Client.scanner.nextLine();

			if (UserService.validatePassword(password))
				break;
			else
				System.out.println("Please Enter Password in the given format only");
		}

		user.setUserName(username);
		user.setPassword(password);
		user.setRole(Role.Employee);
		int userId = userService.add(user);
		System.out.println("Employee is added with id : " + userId);

	}

	private static void deleteEmployee() throws HotelManagementException {

		User user = null;
		System.out.println("Enter Employee ID you wanted to delete : ");

		try {
			int empId = Client.scanner.nextInt();
			user = userService.validateEmpId(empId);
			if (user == null) {
				throw new HotelManagementException();
			} else {
				boolean result = userService.deleteById(empId);
				if (result == true)
					System.out.println("Employee Record Deleted");
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Invalid Employee Id");
		}
	}

	private static void showAllEmployees() throws HotelManagementException {

		if (userService.findAll().isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println("This is the whole list of Users : ");

			userService.findAll().stream().filter((user) -> user.getRole() == Role.Employee)
					.forEach(System.out::println);
		}
	}

	private static void searchEmployee() throws HotelManagementException {

		User user = null;
		Client.scanner.nextLine();
		System.out.println("Enter employee id : ");

		try {
			int empId = Client.scanner.nextInt();
			user = userService.validateEmpId(empId);
			if (user == null) {
				throw new HotelManagementException();
			} else {
				user = userService.findById(empId);
				System.out.println(user.toString());
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Employee Doesn't Exist");
		}

	}

	private static void updateEmployee() throws HotelManagementException {

		Client.scanner.nextLine();
		User user = null;
		System.out.println("Enter the Employee Id : ");

		try {
			int empId = Client.scanner.nextInt();
			user = userService.validateEmpId(empId);
			if (user == null) {
				throw new HotelManagementException();
			} else {

				Client.scanner.nextLine();
				System.out.println("Provide new username to Emoloyee : ");
				String username = Client.scanner.nextLine();

				System.out.println("Provide password : ");
				String password = Client.scanner.nextLine();

				user.setUserName(username);
				user.setPassword(password);
				user.setRole(Role.Employee);

				boolean flag = userService.update(user);
				if (flag == true) {
					System.out.println("Employee Credentials got updated");
					System.out.println(user.toString());
				}
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Id doesnt exist");
		}
	}

	public static void showRoomManagementMenu() throws HotelManagementException {
		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| ROOM MANAGEMENT |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. Add Rooms");
			System.out.println("2. View All Rooms");
			System.out.println("3. Find Room By Id");
			System.out.println("4. Update Room Type");
			System.out.println("5. Previous Menu");
			try {
				choice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}
			switch (choice) {
			case 1:
				addRoom();
				break;
			case 2:
				viewAllRooms();
				break;
			case 3:
				findRoomById();
				break;
			case 4:
				updateRoomType();
				break;
			case 5:
				showAdminMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}

	private static void updateRoomType() throws HotelManagementException {

		Client.scanner.nextLine();
		Room room = null;
		System.out.println("Enter the Room Id : ");

		try {
			int roomId = Client.scanner.nextInt();
			room = roomService.validateRoomId(roomId);
			if (room == null) {
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

					room.setrType(RType.values()[rTypeIndex]);

					System.out.println("Enter Price of that Type : ");
					room.setPrice(Client.scanner.nextDouble());
				}

				boolean flag = roomService.update(room);
				if (flag == true) {
					System.out.println("Room type got updated");
					System.out.println(room.toString());
				}
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Id doesnt exist");
		}

	}

	private static void findRoomById() throws HotelManagementException {

		Room room = null;
		Client.scanner.nextLine();
		System.out.println("Enter Room By id : ");

		try {
			int roomId = Client.scanner.nextInt();
			room = roomService.validateRoomId(roomId);
			if (room == null) {
				throw new HotelManagementException();
			} else {
				room = roomService.findById(roomId);
				System.out.println(room.toString());
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Room Id doesn't Exist");
		}

	}

	private static void viewAllRooms() throws HotelManagementException {
		if (roomService.findAll().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			System.out.println("This is the whole list of Rooms : ");
			roomService.findAll().forEach(System.out::println);
		}
	}

	private static void addRoom() throws HotelManagementException {

		Room room = new Room();
		Hotel hotel = null;
		Client.scanner.nextLine();
		System.out.println("Enter Hotel Id : ");

		try {
			int hotelId = Client.scanner.nextInt();
			hotel = hotelService.validateHotelId(hotelId);
			if (hotel == null) {
				throw new HotelManagementException();
			} else {

				System.out.println("Enter Room Number : ");
				room.setRoomNum(Client.scanner.nextInt());

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

					room.setrType(RType.values()[rTypeIndex]);

					// type.setRoomTypeId(roomTypeService.findAll().size() + 1);

					System.out.println("Enter Price of that Type : ");
					room.setPrice(Client.scanner.nextDouble());
				}

				room.setHotel(hotel);
				int roomId = roomService.add(room);
				System.out.println("Room id : " + roomId);

			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Hotel Id doesn't Exist");
		}
	}

	public static void showHotelManagementMenu() throws HotelManagementException {
		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| HOTEL MANAGEMENT |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. Add Hotel");
			System.out.println("2. View All Hotels");
			System.out.println("3. Find Hotel By Id");
			System.out.println("4. Update Hotel");
			System.out.println("5. Previous Menu");
			try {
				choice = Client.scanner.nextInt();
			} catch (InputMismatchException exp) {
				Client.scanner.next();
			}
			switch (choice) {
			case 1:
				addHotel();
				break;
			case 2:
				viewAllHotels();
				break;
			case 3:
				findHotel();
				break;
			case 4:
				updateHotel();
				break;
			case 5:
				showAdminMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}

	private static void addHotel() throws HotelManagementException {
		Hotel hotel = new Hotel();

		Client.scanner.nextLine();
		System.out.println("Name of the Hotel : ");
		hotel.setHotelName(Client.scanner.nextLine());

		Client.scanner.nextLine();
		System.out.println("Hotel Contact Number : ");
		hotel.setContactNum(Client.scanner.nextLine());

		System.out.println("Hotel Email Id : ");
		hotel.setEmail(Client.scanner.nextLine());

		System.out.println("Hotel City : ");
		hotel.setCity(Client.scanner.nextLine());

		int hotelId = hotelService.add(hotel);
		System.out.println("Hotel is added with id : " + hotelId + " " + hotel.getHotelName());
	}

	private static void updateHotel() throws HotelManagementException {

		System.out.println("Enter Hotel Id : ");

		Hotel hotel = null;
		try {
			int hotelId = Client.scanner.nextInt();
			hotel = hotelService.validateHotelId(hotelId);
			if (hotel == null) {
				throw new HotelManagementException();
			} else {
				while (true) {
					System.out.println("Enter the field you want to update : ");
					System.out.println(" 1. Hotel Name\n 2. Hotel Contact Number\n 3. Email\n 4. Previous Menu");

					int choice = Client.scanner.nextInt();

					switch (choice) {
					case 1:
						Client.scanner.nextLine();
						System.out.println("Enter New Hotel Name : ");
						hotel.setHotelName(Client.scanner.nextLine());

						try {
							hotelService.update(hotel);
							System.out.println("Your Update is done");
						} catch (HotelManagementException exp) {
							System.out.println("");
						}

						break;
					case 2:
						System.out.println("Enter New Hotel Contact Number : ");
						hotel.setContactNum(Client.scanner.nextLine());

						try {
							hotelService.update(hotel);
							System.out.println("Your Update is done");
						} catch (HotelManagementException exp) {
							System.out.println("");
						}
						break;
					case 3:
						System.out.println("Enter New Hotel Email : ");
						hotel.setEmail(Client.scanner.nextLine());

						try {
							hotelService.update(hotel);
							System.out.println("Your Update is done");
						} catch (HotelManagementException exp) {
							System.out.println("");
						}
						break;
					case 4:
						showHotelManagementMenu();
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
				}
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Hotel Id doesn't Exist");
		}

	}

	private static void findHotel() throws HotelManagementException {

		Client.scanner.nextLine();

		Hotel hotel = null;

		System.out.println("Enter Hotel  id : ");

		try {
			int hotelId = Client.scanner.nextInt();
			hotel = hotelService.validateHotelId(hotelId);
			if (hotel == null) {
				throw new HotelManagementException();
			} else {
				hotel = hotelService.findById(hotelId);
				System.out.println(hotel.toString());
			}
		} catch (HotelManagementException | InputMismatchException exp) {
			System.out.println("Invalid Hotel Id");
		}

		showHotelManagementMenu();
	}

	private static void viewAllHotels() throws HotelManagementException {
		if (hotelService.findAll().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			System.out.println("This is the whole list of Hotels : ");
			hotelService.findAll().forEach(System.out::println);
		}
	}

}