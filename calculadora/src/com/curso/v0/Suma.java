package com.curso.v0;

public class Suma implements Operacion{

	@Override
	public int ejecuta(int x, int y) {		
		return x + y;
	}
	
	//Overloading (Sobrecarga)
	public double ejecuta(double x, double y) {
		return x + y;
	}

}
