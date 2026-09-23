package com.curso.v0;

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
		
		Animal animal = new Animal();
		animal.makeSound();
		
		animal = new Duck();
		animal.makeSound();
		
		animal = new Cat();
		animal.makeSound();
		
		animal = new Dog();
		animal.makeSound();
		
	}

}
