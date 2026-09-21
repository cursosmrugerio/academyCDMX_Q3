package com.curso.v0;

public class Principal5 {
	
	public static void main (String... args) {
		
		int x = 10; //PRIMITIVO
		String cadena = "hello"; //OBJECTOS INMUTABLE
		StringBuilder sb = new StringBuilder("hola"); //OBJECTO MUTABLES
		
		cadena = transforma(x,cadena,sb); //*COPIA DEL VALOR* 
		                         //COPIA DEL PRIMITIVO
								 //COPIA DE LA "VARIABLE DE REFERENCIA"
		
		System.out.println(x); //10
		System.out.println(cadena); // hello world
		System.out.println(sb); //hola mundo
		
	}

	private static String transforma(int x, String cadena, StringBuilder sb) {

		x = x + 10;
		sb.append(" mundo");
		return cadena.concat(" world");
		
	}

}
