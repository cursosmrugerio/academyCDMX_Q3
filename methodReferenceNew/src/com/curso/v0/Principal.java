package com.curso.v0;

import java.util.function.Supplier;

class Empleado{
	@Override
	public String toString() {
		return "Empleado []";
	}
}

public class Principal {

	public static void main(String[] args) {
		
		//DEFINICION LAMBDA
		//Supplier<Empleado> sup = () -> new Empleado();
		
		Supplier<Empleado> sup   = Empleado::new;
		
		Empleado emp = sup.get();
		
		System.out.println(emp);
		

	}

}
