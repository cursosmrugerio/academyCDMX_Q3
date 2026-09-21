package com.curso.v0;

class Empleado extends Object{
	
	String nombre;
	int edad;
	
	Empleado(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	public boolean equals(Object o) {
		return this.nombre.equals(((Empleado)o).nombre) && this.edad == ((Empleado)o).edad;
	}
	
}

public class Principal3 {

	public static void main(String[] args) {	
		
		Empleado emp1 = new Empleado("Patrobas",15);
		Empleado emp2 = new Empleado("Patrobas",15);
		
		System.out.println(emp1.equals(emp2));
		

	}
}
