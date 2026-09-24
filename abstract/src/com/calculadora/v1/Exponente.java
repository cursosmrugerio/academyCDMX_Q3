package com.calculadora.v1;

public class Exponente extends Operacion{

	@Override
	int ejecuta(int x, int y) {
		return (int)Math.pow(x, y);
	}

}
