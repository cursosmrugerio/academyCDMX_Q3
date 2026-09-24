package com.calculadora.v2;

public class Multi implements Operacion{

	@Override
	public int ejecuta(int x, int y) {
		return x*y;
	}

	@Override
	public String toString() {
		return "Multi";
	}

}
