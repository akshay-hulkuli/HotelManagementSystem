package com.bridgelabz.hotelmanagement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class DateServiceProvider {
	static int numOfWeekdays = 0, numOfWeekends=0;
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
