package com.curso.v0;

public class Principal {

	public static void main(String[] args) {
		
		//FINAL, CONSTANTE PARA PRIMITIVOS
		final int x = 10;
		//x = 5;
		
		//INMUTABLE
		final String cadena = "Hola";
		//FINAL, NO SE PUEDE CAMBIAR LA REFERENCIA NI ELIMINAR
		//cadena = cadena.concat(" Mundo");
		//cadena = null;
		System.out.println(cadena); //Hola 
		
		//MUTABLE
		final StringBuilder sb = new StringBuilder("Hello ");
		//FINAL, NO SE PUEDE CAMBIAR LA REFERENCIA NI ELIMINAR
		//sb = new StringBuilder("Pato");
		//sb = sb.append("World");
		//sb = null;
		System.out.println(sb);
		
	}

}
