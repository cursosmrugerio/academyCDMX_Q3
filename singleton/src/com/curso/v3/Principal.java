package com.curso.v3;

public class Principal {

	public static void main(String[] args) {

		ConexionDB conn1 = ConexionDB.getInstance();
		
		//System.out.print(conn1); //null
		
		ConexionDB conn2 = ConexionDB.getInstance();
		ConexionDB conn3 = ConexionDB.getInstance();
		ConexionDB conn4 = ConexionDB.getInstance();
		ConexionDB conn999 = ConexionDB.getInstance();
		
		System.out.print(conn1 == conn999);
		System.out.print(conn999 == conn4);
		System.out.print(conn4 == conn3);
		
		
	}

}
