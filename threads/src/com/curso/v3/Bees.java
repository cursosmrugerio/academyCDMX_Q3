package com.curso.v3;

public class Bees {
	public static void main(String[] args) {
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main");
		}

	}

	void go() throws InterruptedException { //SOLO UN Thread tiene acceso al método
		
		Thread t1 = new Thread(); // CREAR Thread
		t1.start(); // INICIA EL Thread
		
		System.out.print("1 ");
		
		synchronized(t1) {
			t1.wait(5000); //ESPERAR 5 SEGUNDOS
		}
		
		System.out.print("2 ");
	}
}