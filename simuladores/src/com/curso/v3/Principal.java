package com.curso.v3;

interface A{
	default void ejecutar() {
		System.out.println("Interface");
	}
}

class B{
	void ejectuar() {
		System.out.println("Clase");
	}
}

class C extends B implements A{
	
}

public class Principal {

	public static void main(String[] args) {
		
		C c = new C();
		c.ejectuar();
		
//		A a = new C();
//		a.ejectuar();

	}

}
