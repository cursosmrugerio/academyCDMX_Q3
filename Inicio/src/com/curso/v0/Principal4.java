package com.curso.v0;

public class Principal4 {
	
	public static void main (String... args) {
		
		int x = 10; //PRIMITIVO
		String cadena = "hello"; //OBJECTOS INMUTABLE
		StringBuilder sb = new StringBuilder("hola"); //OBJECTO MUTABLES
		
		transforma(x,cadena,sb); //*COPIA DEL VALOR* 
		                         //COPIA DEL PRIMITIVO
								 //COPIA DE LA "VARIABLE DE REFERENCIA"
		
		System.out.println(x); //10
		System.out.println(cadena); // hello
		System.out.println(sb); //hola mundo
		
	}

	private static void transforma(int x, String cadena, StringBuilder sb) {

		x = x + 10;
		cadena = cadena.concat(" world");
		sb.append(" mundo");
		
	}

}
