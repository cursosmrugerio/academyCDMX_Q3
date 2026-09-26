package com.curso.v3;

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

public class Principal0 {
	
	public static void main(String[] args) {
		
		System.out.println("***** LAMBDAS ******");
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 223.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		System.out.println("***** ORDENAR POR EDAD ******");
		
		//LAMBDA
		Comparator<Empleado> comparatorEdad = (o1,o2) -> o2.edad - o1.edad;
			
		Arrays.sort(empleados, comparatorEdad);
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR SUELDO ******");
		
		//LAMBDA
		Comparator<Empleado> comparatorSueldo = (pato1,pato2) -> (int)(pato1.sueldo - pato2.sueldo);
			
		Arrays.sort(empleados,comparatorSueldo);
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR NOMBRE ******");
		
		Arrays.sort(empleados, (x,y) -> x.nombre.compareTo(y.nombre));
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
