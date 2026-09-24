package com.calculadora.v2;

public class Exponente extends Operacion{

	@Override
	int ejecuta(int x, int y) {
		return (int)Math.pow(x, y);
	}

}
