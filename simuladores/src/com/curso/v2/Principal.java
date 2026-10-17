package com.curso.v2;

interface a{
	void ejecutar(); //public abstract
}

class b{
	private void ejectuar() {
	}
}

class c extends b implements a{
	@Override
	public void ejecutar() {
		//super.ejectuar();
	}	
}

public class Principal {

	public static void main(String[] args) {

	}

}
