package com.calculadora.v2;

public class Exponente implements Operacion{

	@Override
	public int ejecuta(int x, int y) {
		return (int)Math.pow(x, y);
	}
	
	@Override
	public String toString() {
		return "Exponente";
	}

}
