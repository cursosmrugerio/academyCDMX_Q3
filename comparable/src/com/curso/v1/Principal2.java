package com.curso.v1;

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
	@Override
	public int compareTo(Empleado o) {
		if (this.edad > o.edad)
			return 999;
		else if (this.edad < o.edad)
			return -50;
		else 
			return 0;
	}
}

public class Principal2 {
	
	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 23.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		Arrays.sort(empleados);
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		
	}

}
