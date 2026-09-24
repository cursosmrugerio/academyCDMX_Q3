package com.calculadora.v2;

public abstract class Operacion {
	
	abstract int ejecuta(int x, int y);
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
