package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.*;
public class HotelManagementSystemImpl implements HotelManagementSystemIF {
	DateServiceProvider dateServices = new DateServiceProvider();
	List<Hotel> hotelList = new ArrayList<Hotel>();
	int numOfWeekdays =0, numOfWeekends =0;
	
	
	public void  addHotel(Hotel hotel) {
		hotelList.add(hotel);
		System.out.println(hotel);
	}
	
	public List<Hotel> getCheapestHotel(String date1, String date2) {
		
		LocalDate startDate = dateServices.dateParser(date1);
		LocalDate endDate = dateServices.dateParser(date2);
		
		numOfWeekdays = dateServices.getNumOfWeekdays(startDate, endDate);
		numOfWeekends = (int)(ChronoUnit.DAYS.between(startDate, endDate)+1 ) - numOfWeekdays;
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

}