package com.curso.v0;

class Estudiante {
	
	String nombre; //HAS-A
	int contador; //0 //HAS-A

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
		
		System.out.println(e1.nombre); 
		System.out.println(e2.nombre);  
		System.out.println(e3.nombre); 
		
		System.out.println(e1.contador); //1
		System.out.println(e2.contador); //1 
		System.out.println(e3.contador); //1
		
	}

}
