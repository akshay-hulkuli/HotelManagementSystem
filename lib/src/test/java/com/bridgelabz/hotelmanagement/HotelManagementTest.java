package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HotelManagementTest {

	HotelManagementSystemImpl hotelManagement;
	
	@Before
	public void initialize() {
		hotelManagement = new HotelManagementSystemImpl();
		Hotel firstHotel  = new Hotel();
		firstHotel.setName("Lakewood");
		firstHotel.setWeekdayPrice(110);
		firstHotel.setWeekendPrice(90);
		firstHotel.setRating(3);
		
		Hotel secondHotel  = new Hotel();
		secondHotel.setName("Bridgewood");
		secondHotel.setWeekdayPrice(150);
		secondHotel.setWeekendPrice(50);
		secondHotel.setRating(4);
		
		Hotel thirdHotel  = new Hotel();
		thirdHotel.setName("Ridgewood");
		thirdHotel.setWeekdayPrice(220);
		thirdHotel.setWeekendPrice(150);
		thirdHotel.setRating(5);
		
		hotelManagement.addHotel(firstHotel);
		hotelManagement.addHotel(secondHotel);
		hotelManagement.addHotel(thirdHotel);
		
	}
	
	@Test
	public void givenHotelData_ifCorrect_ShouldGetTrue() {
	
		int oldSize = hotelManagement.hotelList.size();
		Hotel newHotel  = new Hotel();
		newHotel.setName("NewWood");
		newHotel.setWeekdayPrice(220);
		newHotel.setWeekendPrice(150);
		newHotel.setRating(5);
		
		hotelManagement.addHotel(newHotel);
		Assert.assertSame(oldSize+1,hotelManagement.hotelList.size());
	}
	
	@Test
	public void givenDate_find_CheapestHotel() {
		
		List<Hotel> hotels = hotelManagement.getCheapestHotel("11Sep2020","12Sep2020");
		System.out.println("the cheapest hotel is/are : ");
		System.out.println(hotels);
		Assert.assertEquals("Lakewood", hotels.get(0).getName());
		Assert.assertEquals("Bridgewood", hotels.get(1).getName());
	}
}
