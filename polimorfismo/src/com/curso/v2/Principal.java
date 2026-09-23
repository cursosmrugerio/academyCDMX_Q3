package com.curso.v2;

import java.util.Random;

class Animal{
	void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal{
	@Override
	void makeSound() {
		System.out.println("Guau guau");
	}
}

class Cat extends Animal{
	@Override
	void makeSound() {
		System.out.println("Miua miau");
	}
}

class Duck extends Animal{
	@Override
	void makeSound() {
		System.out.println("kuaq kuaq");
	}
}

public class Principal {
	
	public static void main(String... args) {
		Animal animal = getAnimal();
		System.out.println(animal.getClass().getSimpleName());
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
