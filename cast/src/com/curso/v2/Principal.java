package com.curso.v2;

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
		((PatoSilvestre)pato).volarPatoSilvestre();
		pato.volarPato();
		pato.volarAve();
		
		Ave ave = pato;
		ave.volar();
		((PatoSilvestre)ave).volarPatoSilvestre();
		((Pato)ave).volarPato();
		ave.volarAve();
		
		Object obj = ave;
		
		Ave ave1 = (Ave)obj;
		ave1.volar();
		ave1.volarAve();
		
		Pato pato1 = (Pato)obj;
		pato1.volarPato();
		
		PatoSilvestre ps1 = (PatoSilvestre)obj;
		ps1.volarPatoSilvestre();
		
		
	}

}
