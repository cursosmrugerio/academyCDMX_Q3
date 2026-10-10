package com.curso.v4;

public class Principal {

	public static void main(String[] args) {
		String s = new String("Hola");
		show(s);
	}
	
	static String show(String cadena) {
		return cadena.toUpperCase();
	}

}
