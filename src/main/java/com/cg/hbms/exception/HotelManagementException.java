package com.cg.hbms.exception;

import java.util.Arrays;

public class HotelManagementException extends Exception {

	public HotelManagementException() {
	}
	
	public HotelManagementException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "HotelManagementException";
	}

	
}
