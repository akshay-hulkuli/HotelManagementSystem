package com.bridgelabz.hotelmanagement;

import java.util.List;

public interface HotelManagementSystemIF {
	public void  addHotel(Hotel hotel);
	public List<Hotel> getCheapestHotel(String date1, String date2);
	public Hotel getCheapestAndBestRatedHotel(String date1, String date2);
}