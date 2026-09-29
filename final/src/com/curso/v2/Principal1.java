package com.curso.v2;

import java.util.function.Predicate;

public class Principal1 {
	
	public static void main(String... args) {
		boolean r = new Principal1().calcular();
		System.out.println(r);
	}
	
	private boolean calcular() {
		
		int data = 20;
		
		//SI USAS UNA VARIABLE LOCAL EN UNA LAMBDA 
		//LA VARIABLE DEBE SER Effective Final
		Predicate<Integer> pred = i -> i + data > 50;
		
		//data += 1;
		
		return pred.test(31);
	}
}
