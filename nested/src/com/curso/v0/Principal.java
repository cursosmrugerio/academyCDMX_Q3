package com.curso.v0;

public class Principal {
	
	//Inner Class
	//HAS-A
	class Animal{
	}
	
	public static void main(String[] args) {

		Principal.Animal a = new Principal().new Animal();
		
		System.out.println(a);
		
	}

}
