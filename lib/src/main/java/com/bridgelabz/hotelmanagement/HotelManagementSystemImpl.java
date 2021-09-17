package com.bridgelabz.hotelmanagement;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class HotelManagementSystemImpl {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	
	public void  addHotel(Hotel hotel) {
		hotelList.add(hotel);
		System.out.println(hotel);
	}
	
	public Hotel getCheapestHotel(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		Date startDate = null, endDate = null;
		try {
			startDate = sdf.parse(date1);
			endDate = sdf.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diff = endDate.getTime() - startDate.getTime();
		long numOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return hotelList.stream().min((h1,h2) -> h1.getPrice(numOfDays).compareTo(h2.getPrice(numOfDays))).orElse(null);
	}

}
