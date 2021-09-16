package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.*;
import java.util.regex.Pattern;


public class HotelManagementMain {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	int numOfWeekdays =0, numOfWeekends =0;
	
	private static final String DATE_REG_EX = "^[0-3][0-9][A-Z][a-z]{2}(202)[0-9]$";
	
	@FunctionalInterface
	interface Validation{
		boolean inputCheck(String regEx, String input);
	}
	static Validation dataValidator = (String regEx, String input) -> { 
		boolean check= Pattern.matches(regEx,input);
		return check;
	};
	
	public void  addHotel(String name, double weekdayPrice, double weekendPrice, int rating, double rewardedWeekdayPrice, double rewardedweekendPrice) throws HotelManagementException {
		try {
			if(name.length() == 0) throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			Hotel hotel = new Hotel();
			hotel.setName(name);
			hotel.setWeekdayPrice(weekdayPrice);
			hotel.setWeekendPrice(weekendPrice);
			hotel.setRating(rating);
			hotel.setRewardedWeekdayPrice(rewardedWeekdayPrice);
			hotel.setRewardedWeekendPrice(rewardedweekendPrice);
			hotelList.add(hotel);
		}
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
	}
	
	public List<Hotel> getCheapestHotel(String date1, String date2, CustomerType cType) throws HotelManagementException{
		try {
			if(date1.length() == 0 || date2.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			if(!(dataValidator.inputCheck(DATE_REG_EX,date1) && dataValidator.inputCheck(DATE_REG_EX,date2))) {
				System.out.println("enter correct date");
				return null;
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
			LocalDate startDate = null, endDate = null;
	
			startDate = LocalDate.parse(date1,formatter);
			endDate =LocalDate.parse(date2,formatter);
		
			Stream.iterate(startDate, date -> date.plusDays(1))
				  .limit(ChronoUnit.DAYS.between(startDate, endDate)+1)
				  .forEach(date -> {
					  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
					  else numOfWeekdays++;
				  });
		
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
		if(!(dataValidator.inputCheck(DATE_REG_EX,date1) && dataValidator.inputCheck(DATE_REG_EX,date2))) {
			System.out.println("enter correct date");
			return null;
		}
		List<Hotel> cheapestHotels = getCheapestHotel(date1,date2,cType);
		
		return cheapestHotels.stream()
			   .max((h1,h2) -> h1.getRating()-h2.getRating())
			   .orElse(null);
	}
	
	public Hotel getBestRatedHotel(String date1, String date2,CustomerType cType) {
		try {
			if(date1.length() == 0 || date2.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			if(!(dataValidator.inputCheck(DATE_REG_EX,date1) && dataValidator.inputCheck(DATE_REG_EX,date2))) {
				System.out.println("enter correct date");
				return null;
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
			LocalDate startDate = null, endDate = null;
	
			startDate = LocalDate.parse(date1,formatter);
			endDate =LocalDate.parse(date2,formatter);
		
			Stream.iterate(startDate, date -> date.plusDays(1))
				  .limit(ChronoUnit.DAYS.between(startDate, endDate)+1)
				  .forEach(date -> {
					  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
					  else numOfWeekdays++;
				  });
			
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
