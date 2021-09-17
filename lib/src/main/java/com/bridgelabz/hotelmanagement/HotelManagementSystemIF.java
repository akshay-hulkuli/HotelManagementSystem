package com.bridgelabz.hotelmanagement;

import java.util.List;

public interface HotelManagementSystemIF {
	void  addHotel(Hotel hotel);
	List<Hotel> getCheapestHotel(String date1, String date2, CustomerType cType);
	Hotel getCheapestAndBestRatedHotel(String date1, String date2, CustomerType cType);
	Hotel getBestRatedHotel(String date1, String date2,CustomerType cType);
}
