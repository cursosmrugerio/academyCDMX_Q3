package com.curso.v1;

public class ConexionDB {
	
	String port;
	static private ConexionDB conexion;

	private ConexionDB(String port) {
		this.port = port;
	}
	
	static public ConexionDB getInstance() {
		conexion = new ConexionDB("3306");
		return conexion;
	}

}
