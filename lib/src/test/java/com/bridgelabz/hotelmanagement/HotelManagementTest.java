package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		firstHotel.setRewardedWeekdayPrice(80);
		firstHotel.setRewardedWeekendPrice(80);
		
		Hotel secondHotel  = new Hotel();
		secondHotel.setName("Bridgewood");
		secondHotel.setWeekdayPrice(150);
		secondHotel.setWeekendPrice(50);
		secondHotel.setRating(4);
		secondHotel.setRewardedWeekdayPrice(110);
		secondHotel.setRewardedWeekendPrice(50);
		
		Hotel thirdHotel  = new Hotel();
		thirdHotel.setName("Ridgewood");
		thirdHotel.setWeekdayPrice(220);
		thirdHotel.setWeekendPrice(150);
		thirdHotel.setRating(5);
		thirdHotel.setRewardedWeekdayPrice(100);
		thirdHotel.setRewardedWeekendPrice(40);
		
		hotelManagement.addHotel(firstHotel);
		hotelManagement.addHotel(secondHotel);
		hotelManagement.addHotel(thirdHotel);
		
	}
	
	@Test
	public void givenHotelData_ifCorrect_ShouldGetTrue() {
		int oldSize = hotelManagement.hotelList.size();
		Hotel newHotel  = new Hotel();
		newHotel.setName("NewWood");
		newHotel.setWeekdayPrice(110);
		newHotel.setWeekendPrice(90);
		newHotel.setRating(3);
		newHotel.setRewardedWeekdayPrice(80);
		newHotel.setRewardedWeekendPrice(80);
		hotelManagement.addHotel(newHotel);
		Assert.assertSame(oldSize+1,hotelManagement.hotelList.size());
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		
		
		List<Hotel> hotels = hotelManagement.getCheapestHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		
		System.out.println("the cheapest hotel is/are : ");
		System.out.println(hotels);
		System.out.println();
		Assert.assertEquals("Lakewood", hotels.get(0).getName());
		Assert.assertEquals("Bridgewood", hotels.get(1).getName());
	}
	
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel() {
		Hotel hotel = hotelManagement.getCheapestAndBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		System.out.println("the cheapest and best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Bridgewood", hotel.getName());
	}
	
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		
		Hotel hotel = hotelManagement.getBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getName());
	}
	
	
	@Test
	public void givenDateRangeAndRewardedUser_find_BestRatedHotel() {
		Hotel hotel = hotelManagement.getBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REWARDED);
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getName());
	}
	
	@Test
	public void givenDateRange_IfNull_ShouldThrowException() {
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelManagementException.class);
		try {
			Hotel hotel = hotelManagement.getBestRatedHotel(null,"12Sep2020",CustomerType.REWARDED);
		}
		catch(HotelManagementException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}
	
	@Test
	public void givenDateRange_IfEmpty_ShouldThrowException() {
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelManagementException.class);
		try {
			Hotel hotel = hotelManagement.getBestRatedHotel("","12Sep2020",CustomerType.REWARDED);
		}
		catch(HotelManagementException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void givenDateRangeAndCustomerType_IfEmpty_ShouldThrowException() {
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelManagementException.class);
		try {
			Hotel hotel = hotelManagement.getCheapestAndBestRatedHotel("","12Sep2020",CustomerType.REWARDED);
		}
		catch(HotelManagementException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel_forRewardedCustomer() {
		
		Hotel hotel = hotelManagement.getCheapestAndBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REWARDED);
		System.out.println("the cheapest and best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getName());
	}
}
