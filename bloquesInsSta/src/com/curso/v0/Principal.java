package com.curso.v0;

class Pato {
	
	{ //SCOPE 
		System.out.println("PASO BLOQUE INSTANCIA 2");
	}
	
	String nombre;

	public Pato(String nombre) {
		System.out.println("PASO CONSTRUCTOR");
		{
			System.out.println("PASO CONSTRUCTOR 2");
		}
		this.nombre = nombre;
	}
	
	{
		System.out.println("PASO BLOQUE INSTANCIA 1");
	}
}

public class Principal {

	public static void main(String[] args) {

		Pato pato1 = new Pato("Donald");
		
		//PASO BLOQUE INSTANCIA 2
		//PASO BLOQUE INSTANCIA 1
		//PASO CONSTRUCTOR
		
	}

}
