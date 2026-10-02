package com.curso.v2;

import java.util.*;

public class Principal2 {

	public static void main(String[] args) {
		
		List<Object> objetos = new ArrayList<>();
		objetos.add(new Object());
		objetos.add("Filologo");
		objetos.add(new StringBuilder("Epeneto"));
		objetos.add(Double.valueOf(5.0));
		
		List<Object> listaObjects1 = objetos;
	
		List<String> nombres = new ArrayList<>();
		nombres.add("Patrobas");
		nombres.add("Tercio");
		nombres.add("Andronico");
		
		//List<Object> listaObjects2 = nombres;
		List<?> listaObjects2 = nombres;
	
		List<Integer> enteros = new ArrayList<>();
		enteros.add(1); 
		enteros.add(5);
		enteros.add(999);
		
		//List<Object> listaObjects3 = enteros;
		List<?> listaObjects3 = enteros;

	}


	

}
