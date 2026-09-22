package com.curso.v1;

class Pato {
	
	{ //SCOPE 
		System.out.println("PASO BLOQUE INSTANCIA 2");
	}
	
	static { //SCOPE 
		System.out.println("PASO BLOQUE STATIC 2");
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
	
	static { 
		System.out.println("PASO BLOQUE STATIC 1");
	}
}

public class Principal {

	public static void main(String[] args) {

		Pato pato1 = new Pato("Donald");
		
		//PASO BLOQUE STATIC 2
		//PASO BLOQUE STATIC 1
		//PASO BLOQUE INSTANCIA 2
		//PASO BLOQUE INSTANCIA 1
		//PASO CONSTRUCTOR
		
	}

}
