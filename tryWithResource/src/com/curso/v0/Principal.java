package com.curso.v0;

public class Principal {

	public static void main(String[] args)  {

		ConexionMongoDb con = new ConexionMongoDb("1234");
		
		try {
			con.openConexion();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//PROBLEMA NO CERRAMO EL RECURSO (ConexionMongoDb)
		
		System.out.println("End program");
		
		
	}

}
