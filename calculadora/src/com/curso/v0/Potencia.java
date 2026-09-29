package com.curso.v0;

public class Potencia implements Operacion{

	@Override
	public int ejecuta(int x, int y) {		
		return (int)Math.pow(x, y);
	}

}
