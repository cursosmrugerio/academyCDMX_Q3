package com.curso.v2;

import java.util.*;
import static java.util.stream.Collectors.toList;;

public class StreamTest {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("apple", "banana", "cherry", "ate");
		
		List<String> result = items.stream()
                .filter(s -> s.startsWith("a"))
                .collect(toList());
		
		System.out.println(result);
	}

}
