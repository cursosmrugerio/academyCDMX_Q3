package com.curso.v2;

import java.util.Arrays;

class Empleado implements Comparable<Empleado>{
	String nombre;
	int edad;
	double sueldo;
	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}
	@Override //ORDENAR POR SUELDO
	public int compareTo(Empleado o) {
		return (int)(this.sueldo - o.sueldo);
	}
//	@Override //ORDENAR POR NOMBRE
//	public int compareTo(Empleado o) {
//		return this.nombre.compareTo(o.nombre);
//	}
//	@Override //ORDENAR POR EDAD
//	public int compareTo(Empleado o) {
//		return this.edad - o.edad;
//	}
}

public class Principal2 {
	
	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 223.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		Arrays.sort(empleados);
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		
	}

}
