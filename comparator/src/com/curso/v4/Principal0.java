package com.curso.v4;

import java.util.Arrays;
import java.util.Comparator;

class Empleado{
	private String nombre;
	private int edad;
	private double sueldo;
	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}

public class Principal0 {
	
	public static void main(String[] args) {
		
		System.out.println("***** LAMBDAS ******");
		
		Empleado emp1 = new Empleado("Patrobas",30, 123.45);
		Empleado emp2 = new Empleado("Andronico",30, 123.45);
		Empleado emp3 = new Empleado("Epeneto",30, 30.04);
		Empleado emp4 = new Empleado("Filologo",25, 100.80);
		
		Empleado[] empleados = {emp1,emp2,emp3,emp4};
		
		//PROGRAMACION IMPERATIVA - POO (QUE Y EL COMO )
		//PROGRAMACION DECLARATIVA - FUNCTIONAL (QUE)
		
		Comparator<Empleado> comparator = Comparator.comparingInt(Empleado::getEdad)
													.thenComparingDouble(Empleado::getSueldo)
													.thenComparing(Empleado::getNombre)
													.reversed();
		
		Arrays.sort(empleados,comparator);
		
		Arrays.asList(empleados).forEach(System.out::println);
		
		
	}

}
