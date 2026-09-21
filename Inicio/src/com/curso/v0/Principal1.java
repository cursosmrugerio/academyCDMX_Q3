package com.curso.v0;

class Duck{
	String nombre;
	Duck (String nombre){
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		Duck pato = (Duck)o;
		return this.nombre.equals(pato.nombre);
	}
}

public class Principal1 {

	public static void main(String[] args) {

		String cadena1 = "Hello";
		String cadena2 = new String("Hello");
		
		System.out.println(cadena1.equals(cadena2)); //true
		
		StringBuilder sb1 = new StringBuilder("Hola");
		StringBuilder sb2 = new StringBuilder("Hola");

		System.out.println(sb1.equals(sb2)); //false
		
		Duck pato1 = new Duck("Lucas");
		Duck pato2 = new Duck("Lucas");
		
		System.out.println(pato1.equals(pato2)); //false -> true
	}

}
