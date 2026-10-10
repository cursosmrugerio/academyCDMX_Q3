package com.curso.v0;

import java.util.*;

public class StreamTest {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("apple", "banana", "cherry", "date");
		
		//UnsupportedOperationException
		//items.add("x");
		//items.remove("date");
		
		//PERMITIDO
		//items.set(3, "fecha");
		
		items.forEach(t -> System.out.println(t));
		
	}

}
