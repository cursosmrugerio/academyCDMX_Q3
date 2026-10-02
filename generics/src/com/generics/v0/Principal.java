package com.generics.v0;

class Bici{
}

class Moto{
}

class Patin{
}

public class Principal {

	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Moto moto = new Moto();
		Patin patin = new Patin();
		
		Contenedor<Patin> conten1 = new Contenedor<>(patin);
		Contenedor<Bici>  conten2 = new Contenedor<>(bici);
		Contenedor<Moto> conten3 = new Contenedor<>(moto);
		
		Bici bici2 = conten2.getT();

	}

}
