package com.bridgelabz.hotelmanagement;

public class Hotel {
	private String name;
	private double weekendPrice;
	private double weekdayPrice;
	private int rating;
	private double rewardedWeekdayPrice;
	private double rewardedWeekendPrice;

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
	
	public Double getPrice(int numOfWeekdays, int numOfWeekends) {
		return (weekdayPrice*numOfWeekdays + weekendPrice*numOfWeekends);
	}
	
	@Override
	public String toString() {
		return "name: "+this.name+" weekdayPrice: "+this.weekdayPrice+" weekendPrice: "+this.weekendPrice+" rating: "+this.rating+" rewardedWeekdayPrice: "
				+this.rewardedWeekdayPrice+" rewardedWeekEndPrice: "+this.rewardedWeekendPrice; 
	}

	public double getRewardedWeekdayPrice() {
		return rewardedWeekdayPrice;
	}

	public void setRewardedWeekdayPrice(double rewardedWeekdayPrice) {
		this.rewardedWeekdayPrice = rewardedWeekdayPrice;
	}

	public double getRewardedWeekendPrice() {
		return rewardedWeekendPrice;
	}

	public void setRewardedWeekendPrice(double rewardedWeekendPrice) {
		this.rewardedWeekendPrice = rewardedWeekendPrice;
	}

}
