package com.bridgelabz.hotelmanagement;

public class Hotel {
	private String name;
	private double weekdayPrice;
	private double weekendPrice;
	
	public Hotel(String name, double weekdayPrice, double weekendPrice) {
		this.setName(name);
		this.setWeekdayPrice(weekdayPrice);
		this.setWeekendPrice(weekendPrice);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeekdayPrice() {
		return weekdayPrice;
	}

	public void setWeekdayPrice(double weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}

	public double getWeekendPrice() {
		return weekendPrice;
	}

	public void setWeekendPrice(double weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	@Override
	public String toString() {
		return "name: "+this.name+" weekdayPrice: "+this.weekdayPrice+" weekendPrice: "+this.weekendPrice; 
	}
}
