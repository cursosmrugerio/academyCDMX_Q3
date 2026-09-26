package com.curso.v2;

public class Bees {
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName()); //main
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main");
		}

	}

	synchronized void go() throws InterruptedException { //SOLO UN Thread tiene acceso al método
		
		Thread t1 = new Thread(); // CREAR Thread
		t1.start(); // INICIA EL Thread
		
		//System.out.println(Thread.currentThread().getName());
		System.out.print("1 ");
		
		t1.wait(5000); //ESPERAR 5 SEGUNDOS
		
		System.out.print("2 ");
	}
}