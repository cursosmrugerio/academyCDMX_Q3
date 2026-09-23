package com.curso.v5;

import java.util.Random;

class Animal{
	String tipo = "Animal";
	void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal{
	String tipo = "Perro";
	@Override
	void makeSound() {
		System.out.println("Guau guau");
	}
}

class Cat extends Animal{
	String tipo = "Gato";
	@Override
	void makeSound() {
		System.out.println("Miua miau");
	}
}

class Duck extends Animal{
	String tipo = "Pato";
	@Override
	void makeSound() {
		System.out.println("kuaq kuaq");
	}
}

public class Principal {
	
	public static void main(String... args) {
		Animal animal = new Duck();
		//APLICAMOS CAST PARA INDICAR EL TIPO CORRECTO
		System.out.println(((Duck)animal).tipo); 
		//PARA METODOS SE CONSIDERA EL OBJETO
		animal.makeSound(); 
	}


	
}
