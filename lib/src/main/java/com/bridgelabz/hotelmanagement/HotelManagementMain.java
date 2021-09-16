package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.*;
public class HotelManagementMain {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	int numOfWeekdays =0, numOfWeekends =0;
	
	
	public void  addHotel(String name, double weekdayPrice, double weekendPrice, int rating, double rewardedWeekdayPrice, double rewardedweekendPrice) {
		Hotel hotel = new Hotel();
		hotel.setName(name);
		hotel.setWeekdayPrice(weekdayPrice);
		hotel.setWeekendPrice(weekendPrice);
		hotel.setRating(rating);
		hotel.setRewardedWeekdayPrice(rewardedWeekdayPrice);
		hotel.setRewardedWeekendPrice(rewardedweekendPrice);
		hotelList.add(hotel);
	}
	
	public List<Hotel> getCheapestHotel(String date1, String date2) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate startDate = null, endDate = null;

		startDate = LocalDate.parse(date1,formatter);
		endDate =LocalDate.parse(date2,formatter);
	
		Stream.iterate(startDate, date -> date.plusDays(1))
			  .limit(endDate.compareTo(startDate)+1)
			  .forEach(date -> {
				  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
				  else numOfWeekdays++;
			  });
	
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
	
	public Hotel getBestRatedHotel(String date1, String date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate startDate = null, endDate = null;

		startDate = LocalDate.parse(date1,formatter);
		endDate =LocalDate.parse(date2,formatter);
	
		Stream.iterate(startDate, date -> date.plusDays(1))
			  .limit(endDate.compareTo(startDate)+1)
			  .forEach(date -> {
				  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
				  else numOfWeekdays++;
			  });
		
		Hotel bestRatedHotel = hotelList.stream()
							   .max((h1,h2) -> h1.getRating()-h2.getRating())
							   .orElse(null);
		System.out.println("the cost is : "+bestRatedHotel.getPrice(numOfWeekdays, numOfWeekends));
		return bestRatedHotel;
	}
}
