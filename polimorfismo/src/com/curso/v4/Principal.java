package com.curso.v4;

import java.util.Random;

class Animal{
	String tipo = "Animal";
	void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal{
	String tipo = "Dog";
	@Override
	void makeSound() {
		System.out.println("Guau guau");
	}
}

class Cat extends Animal{
	String tipo = "Cat";
	@Override
	void makeSound() {
		System.out.println("Miua miau");
	}
}

class Duck extends Animal{
	String tipo = "Duck";
	@Override
	void makeSound() {
		System.out.println("kuaq kuaq");
	}
}

public class Principal {
	
	public static void main(String... args) {
		Animal animal = new Duck();
		//PARA ATRIBUTOS SE CONSIDERA LA VARIABLE DE REFERENCIA
		System.out.println(animal.tipo); 
		//PARA METODOS SE CONSIDERA EL OBJETO
		animal.makeSound(); 
	}


	
}
