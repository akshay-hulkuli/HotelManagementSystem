package com.bridgelabz.hotelmanagement;

import java.time.LocalDate;

public interface HotelManagementSystemIF {
	public void  addHotel(String name, double regularprice, int rating);
	public Hotel getCheapestHotel(LocalDate date1, LocalDate date2);
}
