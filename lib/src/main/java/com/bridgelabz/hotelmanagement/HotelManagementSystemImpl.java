package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.*;

public class HotelManagementSystemImpl implements HotelManagementSystemIF {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	int numOfWeekdays =0, numOfWeekends =0;
	DateServiceProvider dateService = new DateServiceProvider();
	
	public void  addHotel(Hotel hotel) {
		hotelList.add(hotel);
	}
	
	public List<Hotel> getCheapestHotel(String date1, String date2, CustomerType cType) throws HotelManagementException {
		
		try {
			if(date1.length() == 0 || date2.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			if(!dateService.getDateFormate(date1, date2)) return null;
			LocalDate startDate = dateService.dateParser(date1);
			LocalDate endDate = dateService.dateParser(date2);
			
			numOfWeekdays = dateService.getNumOfWeekdays(startDate, endDate);
			numOfWeekends = (int)(ChronoUnit.DAYS.between(startDate, endDate)+1 ) - numOfWeekdays;
			
			Hotel cheapestHotel = hotelList.stream()
								.min((h1,h2) -> h1.getPrice(numOfWeekdays,numOfWeekends,cType).compareTo(h2.getPrice(numOfWeekdays,numOfWeekends,cType)))
								.orElse(null);
			
			double cheapestPrice = cheapestHotel.getPrice(numOfWeekdays,numOfWeekends,cType);
			System.out.println("the minimum price is : "+cheapestPrice);
			Predicate<Hotel> isMinimum = (hotel) -> (hotel.getPrice(numOfWeekdays,numOfWeekends,cType) == cheapestPrice)?true:false; 
			List<Hotel> cheapestHotels = hotelList.stream()
										 .filter(isMinimum)
										 .collect(Collectors.toList());
			return cheapestHotels;
		}
		
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
		
	}
	
	
	

	public Hotel getCheapestAndBestRatedHotel(String date1, String date2, CustomerType cType) {
		List<Hotel> cheapestHotels = getCheapestHotel(date1,date2,cType);
		return cheapestHotels.stream()
			   .max((h1,h2) -> h1.getRating()-h2.getRating())
			   .orElse(null);
	}
	
	
	
	public Hotel getBestRatedHotel(String date1, String date2,CustomerType cType) {
		try {
			if(date1.length() == 0 || date2.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			if(!dateService.getDateFormate(date1, date2)) return null;
			LocalDate startDate = dateService.dateParser(date1);
			LocalDate endDate = dateService.dateParser(date2);
			numOfWeekdays = dateService.getNumOfWeekdays(startDate, endDate);
			numOfWeekends = (int)(ChronoUnit.DAYS.between(startDate, endDate)+1 ) - numOfWeekdays;
			
			Hotel bestRatedHotel = hotelList.stream()
								   .max((h1,h2) -> h1.getRating()-h2.getRating())
								   .orElse(null);
			System.out.println("the cost is : "+bestRatedHotel.getPrice(numOfWeekdays, numOfWeekends, cType));
			return bestRatedHotel;
		}
		
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
	}
}
