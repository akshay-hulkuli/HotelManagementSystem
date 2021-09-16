package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class HotelManagementTest {
	@Test
	public void givenHotelData_ifCorrect_ShouldGetTrue() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		int oldSize = hotelManagement.hotelList.size();
		hotelManagement.addHotel("Lakewood",100.0,110.0,4);
		Assert.assertSame(oldSize+1,hotelManagement.hotelList.size());
	}
	
	@Test
	public void givenDate_find_CheapestHotel() {
		HotelManagementMain hotelManagement = new HotelManagementMain();
		hotelManagement.addHotel("Lakewood",110.0,90.0,3);
		hotelManagement.addHotel("Bridgewood",150.0,50.0,4);
		hotelManagement.addHotel("Ridgewood",220.0,150.0,5);
		
		List<Hotel> hotels = hotelManagement.getCheapestHotel("11-9-2020","12-9-2020");
		System.out.println("the cheapest hotel is/are : ");
		System.out.println(hotels);
	}
}
