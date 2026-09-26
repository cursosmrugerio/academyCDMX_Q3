package com.curso.v5;

class Pato{
}

public class Bees {
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName()); //main
		System.out.println("Candado Pato");
		try {
			new Bees().go(new Pato());
		} catch (Exception e) {
			System.out.println("thrown to main");
		}
	}

	void go(Pato pato) throws InterruptedException { //SOLO UN Thread tiene acceso al método
		
		Thread t1 = new Thread(); // CREAR Thread
		t1.start(); // INICIA EL Thread
		
		//System.out.println(Thread.currentThread().getName());
		System.out.print("1 ");
		
		synchronized(pato){
			pato.wait(5000); //ESPERAR 5 SEGUNDOS
		}
		
		System.out.print("2 ");
	}
}