package com.curso.v0;

class Pato{
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 999;
	}
	
}

public class Principal {
	public static void main(String[] args) {
		Pato pato1 = new Pato();
		System.out.println(pato1); //hashCode del Object
		
		Pato pato2 = new Pato();
		System.out.println(pato2); //hashCode del Object
		
	}
}
