package com.curso.v0;

abstract class Animal {
    private void speak() {
        System.out.println("Animals make noise");
    }
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.speak();
    }
}
class Dog extends Animal {
    protected void speak() {
        System.out.println("The Dog barks");
    }
}
public class Test {
    public static void main(String... strings) {
        Animal.main(strings);
    }
}