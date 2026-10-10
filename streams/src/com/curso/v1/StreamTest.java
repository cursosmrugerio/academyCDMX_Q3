package com.curso.v1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("apple", "banana", "cherry", "ate");
		
		Stream<String> stream = items.stream();
		
		Predicate<String> pred = s -> s.startsWith("a");
		
		Stream<String> stream2 = stream.filter(pred);
		
		List<String> listaFinal = stream2.collect(Collectors.toList());
		
		listaFinal.forEach(y -> System.out.println(y));
	}

}
