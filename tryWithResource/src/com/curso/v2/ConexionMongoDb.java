package com.curso.v2;

public class ConexionMongoDb implements AutoCloseable{
	
	private String port;

	public ConexionMongoDb(String port) {
		this.port = port;
	}
	
	void openConexion() throws Exception {
		System.out.println("Open conexion MongoDb");
		throw new Exception("Exception open conexion");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Close conexion MongoDb");
		//throw new Exception("Exception close conexion");
	}
}
