package com.curso.v2;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<Object> objetos = new ArrayList<>();
		
		objetos.add(new Object());
		objetos.add("Filologo");
		objetos.add(new StringBuilder("Epeneto"));
		objetos.add(Double.valueOf(5.0));
		show(objetos);
		showUnbounded(objetos);
		
		List<String> nombres = new ArrayList<>();
		
		nombres.add("Patrobas");
		nombres.add("Tercio");
		nombres.add("Andronico");
		
		//NO FUNCIONA LA HERENCIA EN GENERICS
		//show(nombres); 
		showUnbounded(nombres);
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(1); //Autoboxing
		enteros.add(5);
		enteros.add(999);
		//show(enteros); 
		showUnbounded(enteros);

	}

	private static void show(List<Object> objetos) {
		for (Object o: objetos)
			System.out.println(o);
	}
	
	//Unbounded wildcard
	private static void showUnbounded(List<?> objetos) {
		for (Object o: objetos)
			System.out.println(o);
	}
	

}
