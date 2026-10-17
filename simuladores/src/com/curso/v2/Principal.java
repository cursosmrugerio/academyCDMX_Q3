package com.curso.v2;

interface a{
	void ejecutar(); //public abstract
}

class b{
	private void ejecutar() {
	}
}

class c extends b implements a{
	@Override
	public void ejecutar() {
		//super.ejecutar();
	}	
}

public class Principal {

	public static void main(String[] args) {

	}

}
