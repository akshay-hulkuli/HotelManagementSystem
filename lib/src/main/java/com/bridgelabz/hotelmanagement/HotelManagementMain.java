package com.bridgelabz.hotelmanagement;

import java.util.*;
public class HotelManagementMain {
	
	List<Hotel> hotelList = new LinkedList<Hotel>();

	public boolean  addHotel(String name, double weekdayPrice, double weekendPrice) {
		
			Hotel hotel = new Hotel(name, weekdayPrice, weekendPrice);
			System.out.println(hotel);
			int oldSize = hotelList.size();
			hotelList.add(hotel);
			if(oldSize<hotelList.size())
			return true;
			return false;
	}

}
