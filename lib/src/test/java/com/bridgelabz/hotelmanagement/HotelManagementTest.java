package com.bridgelabz.hotelmanagement;

import org.junit.Assert;
import org.junit.Test;


public class HotelManagementTest {
	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		HotelManagementMain hotelmanagement = new HotelManagementMain();
		boolean result = hotelmanagement.addHotel("Lakewood",100.0,110.0);
		Assert.assertTrue(result);
	}
}
