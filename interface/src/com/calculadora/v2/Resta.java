package com.calculadora.v2;

public class Resta implements Operacion {

	@Override
	public int ejecuta(int x, int y) {
		return x-y;
	}
	
	@Override
	public String toString() {
		return "Resta";
	}

}
