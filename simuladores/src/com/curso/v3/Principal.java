package com.curso.v3;

interface A{
	default void ejecutar() {
		System.out.println("Interface");
	}
}

class B{
	void ejecutar() {
		System.out.println("Clase");
	}
}

class C extends B implements A{ //NO COMPILA: acceso mas debil (B.ejecutar es de paquete, A.ejecutar es public)
	
}

public class Principal {

	public static void main(String[] args) {
		
		C c = new C();
		c.ejecutar();
		
//		A a = new C();
//		a.ejecutar();

	}

}
