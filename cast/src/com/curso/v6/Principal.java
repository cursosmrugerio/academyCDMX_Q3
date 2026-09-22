package com.curso.v6;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
	void volarAve() {
		System.out.println("volarAve()");
	}
}

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
		
		Pato pato = ps;
		
		Ave ave = pato;
		
		Object obj = ave;
		
		Ave ave2 = (Ave)obj;
		
		if (ave2 instanceof Aguila aguila) 
			aguila.volar();		
		
		if (ave2 instanceof PatoSilvestre ps2) 
			ps2.volar();		
		
		
		System.out.println("End Program Pattern Matching");
			
		
	}

}
