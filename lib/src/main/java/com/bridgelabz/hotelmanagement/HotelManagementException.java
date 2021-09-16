package com.bridgelabz.hotelmanagement;

public class HotelManagementException extends RuntimeException {
	enum exceptionType{
		ENTERED_NULL,ENTERED_EMPTY
	}
	exceptionType type;
	public HotelManagementException(exceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
