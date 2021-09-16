package com.bridgelabz.hotelmanagement;

import java.util.*;
public class HotelManagementMain {
	
	List<Hotel> hotelList = new LinkedList<Hotel>();

	public boolean  addHotel(String name, double weekdayPrice, double weekendPrice) {
		Hotel hotel = new Hotel(name, weekdayPrice, weekendPrice);
		System.out.println(hotel);
		hotelList.add(hotel);
		return true;
	}

}
