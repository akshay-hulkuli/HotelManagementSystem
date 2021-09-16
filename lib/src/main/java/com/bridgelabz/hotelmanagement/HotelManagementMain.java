package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.*;
public class HotelManagementMain {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	int numOfWeekdays =0, numOfWeekends =0;
	
	
	public void  addHotel(String name, double weekdayPrice, double weekendPrice, int rating) {
		Hotel hotel = new Hotel(name, weekdayPrice, weekendPrice, rating);
		hotelList.add(hotel);
	}
	
	public List<Hotel> getCheapestHotel(String date1, String date2) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
		try {
			startDate.setTime(sdf.parse(date1));
			endDate.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		do {
			if(startDate.get(Calendar.DAY_OF_WEEK) == 0 || startDate.get(Calendar.DAY_OF_WEEK) == 6) numOfWeekends++;
			else numOfWeekdays++;
			startDate.add(Calendar.DATE,1);
		} while(startDate.compareTo(endDate) <=0);
		
		Hotel cheapestHotel = hotelList.stream()
							.min((h1,h2) -> h1.getPrice(numOfWeekdays,numOfWeekends).compareTo(h2.getPrice(numOfWeekdays,numOfWeekends)))
							.orElse(null);
		
		double cheapestPrice = cheapestHotel.getPrice(numOfWeekdays,numOfWeekends);
		System.out.println("the minimum price is : "+cheapestPrice);
		Predicate<Hotel> isMinimum = (hotel) -> (hotel.getPrice(numOfWeekdays,numOfWeekends) == cheapestPrice)?true:false; 
		List<Hotel> cheapestHotels = hotelList.stream()
									 .filter(isMinimum)
									 .collect(Collectors.toList());
		return cheapestHotels;
	}

	public Hotel getCheapestAndBestRatedHotel(String date1, String date2) {
		List<Hotel> cheapestHotels = getCheapestHotel(date1,date2);
		
		return cheapestHotels.stream()
			   .max((h1,h2) -> h1.getRating()-h2.getRating())
			   .orElse(null);
	}
}
