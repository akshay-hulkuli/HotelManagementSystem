package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class HotelManagementTest {
	
	@Test
	public void givenHotelData_ifCorrect_ShouldGetTrue() {
		HotelManagementSystemImpl hotelManagement = new HotelManagementSystemImpl();
		int oldSize = hotelManagement.hotelList.size();
		hotelManagement.addHotel("Lakewood",100.0,4);
		Assert.assertSame(oldSize+1,hotelManagement.hotelList.size());
	}
	
	@Test
	public void givenDate_find_CheapestHotel() {
		HotelManagementSystemImpl hotelManagement = new HotelManagementSystemImpl();
		hotelManagement.addHotel("Lakewood",100.0,4);
		hotelManagement.addHotel("Bridgewood",110.0,4);
		hotelManagement.addHotel("Ridgewood",105.0,4);
		LocalDate date1 = LocalDate.of(2021, 9, 10);
		LocalDate date2 = LocalDate.of(2021, 9, 11);
		Hotel hotel = hotelManagement.getCheapestHotel(date1, date2);
		System.out.println(hotel);
	}
}
