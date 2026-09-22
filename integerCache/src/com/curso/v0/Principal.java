package com.curso.v0;

public class Principal {
	
	public static void main(String... patos) {
		
		// -128 al 127  //cache Integer
		
		Integer integer1 = 127; //Autoboxing
		Integer integer2 = 127;
			
		System.out.println(integer1 == integer2); //true
		
		Integer integer3 = 128;
		Integer integer4 = 128;
			
		System.out.println(integer3 == integer4); //false
		
		
		
	}

}
