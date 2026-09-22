package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		
		ConexionDB conn1 = new ConexionDB("3306");
		ConexionDB conn2 = new ConexionDB("3306");
		ConexionDB conn3 = new ConexionDB("3306");
		ConexionDB conn4 = new ConexionDB("3306");
		ConexionDB conn999 = new ConexionDB("3306");
		
		System.out.print(conn1 == conn999);
		System.out.print(conn999 == conn4);
		System.out.print(conn4 == conn3);
		
		
	}

}
