package com.curso.v2;

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
		
		System.out.println("***** CLASES ANONIMAS ******");
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 223.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		System.out.println("***** ORDENAR POR EDAD ******");
		
		//CLASE ANONIMA
		Comparator<Empleado> comparatorEdad = new Comparator<>() {
			@Override
			public int compare(Empleado o1, Empleado o2) {
				return o1.edad - o2.edad;
			}
		};
		
		Arrays.sort(empleados, comparatorEdad);
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR SUELDO ******");
		
		//CLASE ANONIMA
		Comparator<Empleado> comparatorSueldo = new Comparator<>() {
			@Override
			public int compare(Empleado pato1, Empleado pato2) {
				return (int)(pato1.sueldo - pato2.sueldo);
			}
		};
		
		Arrays.sort(empleados,comparatorSueldo);
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR NOMBRE ******");
		
		
		Arrays.sort(empleados, new Comparator<>() {
			@Override
			public int compare(Empleado o1, Empleado o2) {
				return o2.nombre.compareTo(o1.nombre);
			}
		});
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
