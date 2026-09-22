package com.curso.v1;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
	
	void volarAve() {
		System.out.println("volarAve()");
	}
}
//          IS A
class Pato extends Ave{
	@Override
	void volar() {
		System.out.println("Pato volar");
	}
	void volarPato() {
		System.out.println("volarPato()");
	}
}
class PatoSilvestre extends Pato{
	@Override
	void volar() {
		System.out.println("Pato Silvestre no volar");
	}
	void volarPatoSilvestre() {
		System.out.println("volarPatoSilvestre()");
	}
}
class Aguila extends Ave{	
	@Override
	void volar() {
		System.out.println("Aguila volar");
	}
	void volarAguila() {
		System.out.println("volarAguila()");
	}
}

public class Principal {

	public static void main(String[] args) {
		
		PatoSilvestre ps = new PatoSilvestre();
		ps.volar();
		ps.volarPatoSilvestre();
		ps.volarPato();
		ps.volarAve();
		
		Pato pato = ps;
		pato.volar();
		//pato.volarPatoSilvestre();
		pato.volarPato();
		pato.volarAve();
		
		Ave ave = pato;
		ave.volar();
		//ave.volarPatoSilvestre();
		//ave.volarPato();
		ave.volarAve();
		
		Object obj = ave;
		//obj.volar();
		//obj.volarPatoSilvestre();
		//obj.volarPato();
		//obj.volarAve();
		
	}

}
