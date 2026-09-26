package com.curso.v0;

import java.util.Arrays;

public class Principal {
	
	public static void main(String... args) {
		
		String[] textos = {"aA", "Az", "5", "111", "z22", "T1"};
		
		//System.out.println(textos);
		
		Arrays.sort(textos);
	
		System.out.println(Arrays.toString(textos));
		
		//111, 5, Az, T1, aA, z22
		
		Integer[] enteros = { 666, 7 , 987, 3 , 6};
		
		Arrays.sort(enteros);
		
		System.out.println(Arrays.toString(enteros));
		
		
	}

}
