package com.curso.v3;

public class ConexionDB {
	
	String port;
	static private ConexionDB conexion = new ConexionDB("3306");

	private ConexionDB(String port) {
		this.port = port;
	}
	
	static public ConexionDB getInstance() {
		return conexion;
	}

}
