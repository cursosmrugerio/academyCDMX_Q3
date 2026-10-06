package com.curso.v1;

public class ConexionMongoDb {
	
	private String port;

	public ConexionMongoDb(String port) {
		this.port = port;
	}
	
	void openConexion() throws Exception {
		System.out.println("Open conexion MongoDb");
		throw new Exception("Exception open conexion");
	}
	
	void closeConexion() throws Exception {
		System.out.println("Close conexion MongoDb");
		//throw new Exception("Exception close conexion");
	}
}
