package com.bridgelabz.hotelmanagement;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class HotelManagementMain {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	
	public void  addHotel(String name, double regularprice, int rating) {
		Hotel hotel = new Hotel(name, regularprice, rating);
		hotelList.add(hotel);
		System.out.println(hotel);
	}
	
	public Hotel getCheapestHotel(LocalDate date1, LocalDate date2) {
		Period period = Period.between(date1, date2);
		int numOfDays = period.getDays();
		return hotelList.stream().min((h1,h2) -> h1.getPrice(numOfDays).compareTo(h2.getPrice(numOfDays))).orElse(null);
	}

}
