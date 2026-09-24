package com.calculadora.v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V1");
		Operacion ope1 = new Suma();
		Operacion ope2 = new Resta();
		Operacion ope3 = new Exponente();
		
		List<Operacion> operaciones = new ArrayList<>();
		operaciones.add(ope1);
		operaciones.add(ope2);
		operaciones.add(ope3);
		
		for(Operacion oper : operaciones)
			show(oper);
	}

	private static void show(Operacion ope) {
		System.out.println(ope);
		int resultado = ope.ejecuta(8, 4);
		System.out.println(resultado);
	}

}
