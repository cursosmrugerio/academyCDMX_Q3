package com.curso.v2;

public class ConexionDB {
	
	String port;
	static private ConexionDB conexion;

	private ConexionDB(String port) {
		this.port = port;
	}
	
	static public ConexionDB getInstance() {
		if (conexion == null)
			conexion = new ConexionDB("3306");
		return conexion;
	}

}
