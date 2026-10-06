package com.curso.v1;

public class Principal {
	
	//Static Nested Class
	//HAS-A
	static class Animal{
	}
	
	public static void main(String[] args) {

		Principal.Animal a = new Principal.Animal();
		
		System.out.println(a);
		
	}

}
