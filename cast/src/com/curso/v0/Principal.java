package com.curso.v0;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
}
//          IS A
class Pato extends Ave{
	@Override
	void volar() {
		System.out.println("Pato volar");
	}
}
class Aguila extends Ave{	
}

public class Principal {

	public static void main(String[] args) {

		Ave ave = new Ave();
		ave.volar(); //Ave volar
		
		Pato pato = new Pato();
		pato.volar(); //Pato volar
		
		Ave ave1 = new Pato();
		ave1.volar(); //Pato volar
		
		Object obj = new Pato();
		//obj.volar();
		((Ave)obj).volar();
		((Pato)obj).volar();
	}

}
