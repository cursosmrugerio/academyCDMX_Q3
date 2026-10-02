package com.curso.v0;

import java.time.*;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println(LocalDate.now()); 
		System.out.println(LocalTime.now()); 
		System.out.println(LocalDateTime.now()); 
		System.out.println(ZonedDateTime.now());

		//INMUTABLE
		LocalDate date = LocalDate.of(2024, Month.JANUARY, 20); 
		date.plusDays(10); 
		System.out.println(date);
		
		
		
	}

}
