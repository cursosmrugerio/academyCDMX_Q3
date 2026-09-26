package com.curso.v0;

public class Bees {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		new Bees().go();

	}

	void go() {
		
		Thread t1 = new Thread(); // CREAR Thread
		t1.start(); // INICIA EL Thread
		
		System.out.println(Thread.currentThread().getName());
		System.out.print("1 ");
		System.out.print("2 ");
	}
}