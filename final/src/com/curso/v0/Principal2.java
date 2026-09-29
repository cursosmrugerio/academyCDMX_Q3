package com.curso.v0;

class Animal{
	final void volar() {}
	
	final static void comer() {}
}

class Pato extends Animal{
	//NO SE PUEDE SOBREESCRIBIR
	//@Override
	//void volar() {}
	
	//NO SE PUEDE OCULTAR
	//HIDDEN
	//static void comer() {}
}

public class Principal2 {

	public static void main(String[] args) {
		
	}
}
