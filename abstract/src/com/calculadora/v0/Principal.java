package com.calculadora.v0;

public class Principal {

	public static void main(String[] args) {

		Operacion ope1 = new Suma();
		show(ope1);
		
		Operacion ope2 = new Resta();
		show(ope2);
		
		Operacion ope3 = new Exponente();
		show(ope3);
	}

	private static void show(Operacion ope) {
		System.out.println(ope);
		int resultado = ope.ejecuta(8, 4);
		System.out.println(resultado);
	}

}
