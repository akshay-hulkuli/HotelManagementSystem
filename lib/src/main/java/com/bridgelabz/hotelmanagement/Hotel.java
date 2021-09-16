package com.bridgelabz.hotelmanagement;


public class Hotel {
	private String name;
	private double weekendPrice;
	private double weekdayPrice;
	private int rating;
	
	public Hotel(String name, double weekdayPrice, double weekendPrice,  int rating) {
		this.name = name;
		this.weekdayPrice = weekdayPrice;
		this.setWeekendPrice(weekendPrice);
		this.setRating(rating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setWeekdayPrice(double weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	
	public double getWeekdayPrice() {
		return this.weekdayPrice;
	}
	
	public double getWeekendPrice() {
		return weekendPrice;
	}

	public void setWeekendPrice(double weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	public Double getPrice(long numOfDays) {
		return weekdayPrice*numOfDays;
	}
	
	@Override
	public String toString() {
		return "name: "+this.name+" weekdayPrice: "+this.weekdayPrice+" weekendPrice: "+this.weekendPrice+" rating: "+this.rating; 
	}

}
