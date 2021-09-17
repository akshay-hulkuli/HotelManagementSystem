package com.bridgelabz.hotelmanagement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class DateServiceProvider {
	static int numOfWeekdays = 0, numOfWeekends=0;
	private static final String DATE_REG_EX = "^[0-3][0-9][A-Z][a-z]{2}(202)[0-9]$";
	
	@FunctionalInterface
	interface Validation{
		boolean inputCheck(String regEx, String input);
	}
	static Validation dataValidator = (String regEx, String input) -> { 
		boolean check= Pattern.matches(regEx,input);
		return check;
	};
	
	
	public boolean getDateFormate(String date1, String date2) {
		if((dataValidator.inputCheck(DATE_REG_EX,date1) && dataValidator.inputCheck(DATE_REG_EX,date2))) return true;
		System.out.println("enter correct date");
		return false;
	}
	
	public LocalDate dateParser(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate formatedDate = LocalDate.parse(date,formatter);
		return formatedDate;
	}
	
	public int getNumOfWeekdays(LocalDate startDate, LocalDate endDate) {
		numOfWeekdays =0;
		numOfWeekends =0;
		Stream.iterate(startDate, date -> date.plusDays(1))
		  .limit(ChronoUnit.DAYS.between(startDate, endDate)+1)
		  .forEach(date -> {
			  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
			  else numOfWeekdays++;
		  });
		
		return numOfWeekdays;
	}
}
