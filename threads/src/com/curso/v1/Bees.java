package com.curso.v1;

public class Bees {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); //main
		new Bees().go();

	}

	synchronized void go() { //SOLO UN Thread tiene acceso al método
		
		Thread t1 = new Thread(); // CREAR Thread
		t1.start(); // INICIA EL Thread
		
		System.out.println(Thread.currentThread().getName());
		System.out.print("1 ");
		System.out.print("2 ");
	}
}