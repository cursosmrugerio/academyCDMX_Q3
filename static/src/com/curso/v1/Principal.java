package com.curso.v1;

class Estudiante {
	
	String nombre; //HAS-A
	static int contador; //0 //HAS-A

	public Estudiante(String nombre) {
		this.nombre = nombre;
		contador++;
	}
	
	
	
}

public class Principal {
	
	public static void main (String... args) {
		
		Estudiante e1 = new Estudiante("Patrobas");
		Estudiante e2 = new Estudiante("Filologo");
		Estudiante e3 = new Estudiante("Epeneto");
		
		System.out.println(e1.contador); //1 //3
		System.out.println(e2.contador); //2 //3
		System.out.println(e3.contador); //3 //3
		
	}

}
