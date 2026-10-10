package com.curso.v1;

import java.util.function.Function;
import java.util.function.Supplier;

class Empleado{
	String nombre;

	public Empleado() {}
	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + "]";
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
	}

}
