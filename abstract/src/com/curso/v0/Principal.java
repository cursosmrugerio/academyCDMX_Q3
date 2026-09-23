package com.curso.v0;

import java.util.Random;

abstract class Animal{
	abstract void makeSound();
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
		System.out.println("Abstract v0");
		Animal animal = getAnimal();
		System.out.println(animal.getClass().getSimpleName());
		animal.makeSound(); 
	}

	private static Animal getAnimal() {
		
		Animal[] animales = {
				//new Animal(), //0
				new Dog(), //0
				new Duck(), //1
				new Cat() //2
		};
		
		int aleatorio = new Random().nextInt(3);
		
		return animales[aleatorio];
	}
	
}
