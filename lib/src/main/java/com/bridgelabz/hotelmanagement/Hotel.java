package com.bridgelabz.hotelmanagement;

import java.time.*;


public class Hotel {
	private String name;
	private double regularPrice;
	private int rating;
	
	public Hotel(String name, double regularPrice, int rating) {
		this.name = name;
		this.regularPrice = regularPrice;
		this.setRating(rating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double regularPrice() {
		return regularPrice;
	}

	public void regularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Double getPrice(int numOfDays) {
		return regularPrice*numOfDays;
	}
	
	@Override
	public String toString() {
		return "name: "+this.name+" regularPrice: "+this.regularPrice+" rating: "+this.rating; 
	}
}
