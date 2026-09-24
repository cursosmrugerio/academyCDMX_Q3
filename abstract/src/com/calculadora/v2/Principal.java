package com.calculadora.v2;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V2");
		
		List<Operacion> operaciones = new ArrayList<>();
		operaciones.add(new Suma());
		operaciones.add(new Resta());
		operaciones.add(new Exponente());
		
		for(Operacion oper : operaciones)
			show(oper);
	}

	private static void show(Operacion ope) {
		System.out.println(ope);
		int resultado = ope.ejecuta(8, 4);
		System.out.println(resultado);
	}

}
