package com.curso.v2;

import java.util.function.Predicate;

public class Principal {
	
	int data = 20;
	
	public static void main(String... args) {
		boolean r = new Principal().calcular();
		System.out.println(r);
	}
	
	private boolean calcular() {
		Predicate<Integer> pred = i -> i + data > 50; //DEFINO
		
		data += 1;
		
		return pred.test(30); //EJECUTO
	}
}
