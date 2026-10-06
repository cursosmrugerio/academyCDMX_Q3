package com.curso.v2;

public class Principal {

	public static void main(String[] args)  {

		try (ConexionMongoDb con = new ConexionMongoDb("1234")) {
			con.openConexion();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("End program");
		
	}

}
