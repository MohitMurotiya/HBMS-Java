package com.cg.hbms.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.hbms.exception.HotelManagementException;
import com.cg.hbms.service.BookingDetailsService;
import com.cg.hbms.service.BookingDetailsServiceImpl;
import com.cg.hbms.store.HotelRepository;

public class Client {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws HotelManagementException {

		HotelRepository.addDetails();
		showMainMenu();
	}

	public static void showMainMenu() throws HotelManagementException {

		int roleType = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| Hello and Welcome to our Hotel Management Program  |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. ADMIN");
			System.out.println("2. EMPLOYEE");
			System.out.println("3. CUSTOMER");
			System.out.println("4. EXIT");
			
			try {
				roleType = scanner.nextInt();
			} catch (InputMismatchException exp) {
				scanner.next();
			}

			switch (roleType) {
			case 1:
				showAdminLogin();
				break;
			case 2:
				showEmployeeMenu();
				break;
			case 3:
				showCustomerLogin();
			case 4:
				System.out.println("Thank You..!!");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	private static void showCustomerLogin() throws HotelManagementException {

		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| 			  CUSTOMER 			|");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. REGISTER");
			System.out.println("2. LOGIN");
			System.out.println("3. Previous Menu");

			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException exp) {
				scanner.next();
			}

			switch (choice) {
			case 1:
				CustomerUserInterface.customerRegistration();
				break;
			case 2:
				CustomerUserInterface.customerLogin();
				break;
			case 3:
				showMainMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}

	private static void showEmployeeMenu() throws HotelManagementException {

		int choice = 0;
		while (true) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("| 						EMPLOYEE 		             |");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
			System.out.println("Please select one of the following options.");
			System.out.println("1. LOGIN");
			System.out.println("2. Previous Menu");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException exp) {
				scanner.next();
			}

			switch (choice) {
			case 1:
				EmployeeUserInterface.employeeLogin();
				break;
			case 2:
				showMainMenu();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	private static void showAdminLogin() throws HotelManagementException {

		scanner.nextLine();
		while (true) {
			System.out.println("Enter username : ");
			String adminUsername = scanner.nextLine();
			System.out.println("Enter password : ");
			String adminPass = scanner.nextLine();

			if (adminUsername.equals("admin") && adminPass.equals("123")) {
				AdminUserInterface.showAdminMenu();
				break;
			} else {
				System.out.println("Given username or password is wrong");
			}
		}
	}
}
