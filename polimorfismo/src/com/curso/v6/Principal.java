package com.curso.v6;

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
		Animal animal = getAnimal();
		
		if (animal instanceof Dog)
			System.out.println(((Dog)animal).tipo);
		else if (animal instanceof Cat)
			System.out.println(((Cat)animal).tipo);
		else if (animal instanceof Duck)
			System.out.println(((Duck)animal).tipo);
		else
			System.out.println(animal.tipo);
		
		animal.makeSound(); 
	}

	private static Animal getAnimal() {
		
		Animal[] animales = {
				new Animal(), //0
				new Dog(), //1
				new Duck(), //2
				new Cat() //3
		};
		
		int aleatorio = new Random().nextInt(4);
		
		return animales[aleatorio];
	}
	
}
