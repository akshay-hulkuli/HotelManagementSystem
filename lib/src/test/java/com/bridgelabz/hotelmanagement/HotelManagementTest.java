package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class HotelManagementTest {
	@Test
	public void givenHotelData_ifCorrect_ShouldGetTrue() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		int oldSize = hotelManagement.hotelList.size();
		hotelManagement.addHotel("Lakewood",100.0,110.0,3,80.0,80.0);
		Assert.assertSame(oldSize+1,hotelManagement.hotelList.size());
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		hotelManagement.addHotel("Lakewood",110,90,3,80,80);
		hotelManagement.addHotel("Bridgewood",150,50,4,110,50);
		hotelManagement.addHotel("Ridgewood",220,150,5,100,40);
		
		List<Hotel> hotels = hotelManagement.getCheapestHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		
		System.out.println("the cheapest hotel is/are : ");
		System.out.println(hotels);
		System.out.println();
		Assert.assertEquals("Lakewood", hotels.get(0).getName());
		Assert.assertEquals("Bridgewood", hotels.get(1).getName());
	}
	
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		hotelManagement.addHotel("Lakewood",110,90,3,80,80);
		hotelManagement.addHotel("Bridgewood",150,50,4,110,50);
		hotelManagement.addHotel("Ridgewood",220,150,5,100,40);
		
		Hotel hotel = hotelManagement.getCheapestAndBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		System.out.println("the cheapest and best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Bridgewood", hotel.getName());
	}
	
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		hotelManagement.addHotel("Lakewood",110,90,3,80,80);
		hotelManagement.addHotel("Bridgewood",150,50,4,110,50);
		hotelManagement.addHotel("Ridgewood",220,150,5,100,40);
		
		Hotel hotel = hotelManagement.getBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REGULAR);
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getName());
	}
	
	@Test
	public void givenDateRangeAndRewardedUser_find_BestRatedHotel() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		hotelManagement.addHotel("Lakewood",110,90,3,80,80);
		hotelManagement.addHotel("Bridgewood",150,50,4,110,50);
		hotelManagement.addHotel("Ridgewood",220,150,5,100,40);
		
		Hotel hotel = hotelManagement.getBestRatedHotel("11Sep2020","12Sep2020",CustomerType.REWARDED);
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", hotel.getName());
	}
}
