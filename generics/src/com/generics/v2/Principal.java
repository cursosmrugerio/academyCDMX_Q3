package com.generics.v2;

abstract class Transporte{
	@Override
	public String toString() {
		return "Transporte:" +this.getClass().getSimpleName();
	}
}

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
		
		conten1.mostrarCertificado("ABC");
		conten2.<StringBuilder>mostrarCertificado(new StringBuilder("XYZ"));
		conten3.mostrarCertificado(Double.valueOf(123.45));

	}

}
