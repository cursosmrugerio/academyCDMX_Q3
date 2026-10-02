package com.generics.v1;

abstract class Transporte{}

class Bici extends Transporte{}

class Moto extends Transporte{}

class Patin extends Transporte{}

public class Principal {

	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Moto moto = new Moto();
		Patin patin = new Patin();
		
		Contenedor<Patin> conten1 = new Contenedor<>(patin);
		Contenedor<Bici>  conten2 = new Contenedor<>(bici);
		Contenedor<Moto> conten3 = new Contenedor<>(moto);
		
		Bici bici2 = conten2.getT();
		
		System.out.println(bici2);
		
		//Contenedor<StringBuilder> conten4 = 
		//		new Contenedor<>(new StringBuilder("ABC"));

	}

}
