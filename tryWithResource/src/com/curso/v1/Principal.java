package com.curso.v1;

public class Principal {

	public static void main(String[] args)  {

		ConexionMongoDb con = new ConexionMongoDb("1234");
		
		try {
			con.openConexion();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.closeConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("End program");
		
		
	}

}
