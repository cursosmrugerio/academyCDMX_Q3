package com.curso.v0;

import java.util.Arrays;
import java.util.Comparator;

class Empleado{
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
}

class ComparatorEdad implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		return o1.edad - o2.edad;
	}
}

public class Principal0 {
	
	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 223.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		Arrays.sort(empleados,new ComparatorEdad());
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		
	}

}
