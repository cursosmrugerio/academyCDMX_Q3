package com.curso.v2;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Empleado{
	String nombre;
	int edad;
	double sueldo;

	public Empleado() {}
	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public Empleado(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Empleado(String nombre, int edad, double sueldo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}

}

public class Principal {

	public static void main(String[] args) {
		
		//DEFINICION LAMBDA
		//Supplier<Empleado> sup = () -> new Empleado();
		Supplier<Empleado> sup   = Empleado::new;
		Empleado emp = sup.get();
		System.out.println(emp);
		
		//Function<String,Empleado> fun = name -> new Empleado(name);
		Function<String,Empleado> fun = Empleado::new;
		emp = fun.apply("Patrobas");
		System.out.println(emp);
		
		
		//BiFunction<String,Integer,Empleado> bifun = 
		//								(name,age) -> new Empleado(name,age);	
		BiFunction<String,Integer,Empleado> bifun = Empleado::new;
		emp = bifun.apply("Epeneto", 20);
		System.out.println(emp);
		
		//TriFunction<String,Integer,Double,Empleado> trifun =
		//		(name,age,salary) -> new Empleado(name,age,salary);	
		TriFunction<String,Integer,Double,Empleado> trifun = Empleado::new;
		emp = trifun.apply("Filologo", 20, 100.00);
		System.out.println(emp);
		
				
	}
}
