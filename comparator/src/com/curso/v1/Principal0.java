package com.curso.v1;

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
class ComparatorSueldo implements Comparator<Empleado>{
	@Override
	public int compare(Empleado pato1, Empleado pato2) {
		return (int)(pato1.sueldo - pato2.sueldo);
	}
}
class ComparatorNombre implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		return o1.nombre.compareTo(o2.nombre);
	}
}

public class Principal0 {
	
	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",28, 223.55);
		Empleado emp3 = new Empleado("Epeneto",18, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		System.out.println("***** ORDENAR POR EDAD ******");
		Arrays.sort(empleados,new ComparatorEdad());
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR SUELDO ******");
		Arrays.sort(empleados,new ComparatorSueldo());
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***** ORDENAR POR NOMBRE ******");
		Arrays.sort(empleados,new ComparatorNombre());
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
