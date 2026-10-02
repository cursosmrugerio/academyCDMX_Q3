package com.curso.v0;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PrincipalPeriod {

	public static void main(String[] args) {
		
		Period annually = Period.ofYears(1); 
		Period quarterly = Period.ofMonths(3); 
		Period everyThreeWeeks = Period.ofWeeks(3); 
		Period everyOtherDay = Period.ofDays(2); 
		Period everyYearAndAWeek = Period.of(1, 0, 7);
		
		LocalDate start = LocalDate.now();
		
		//start = start.plus(everyYearAndAWeek);
		//System.out.println(start);
		
		LocalDateTime start2 = LocalDateTime.now();
		
		LocalDateTime dateTime = start2.minusDays(1)
				                       .minusHours(10)
				                       .minusSeconds(30);
		
		System.out.println(dateTime);
		
		Period malo = Period.ofYears(1).ofWeeks(1); 
		
		System.out.println(malo);
		
		
		
		

	}

}
