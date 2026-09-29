package com.curso.v1;

public class Principal {

	public static void main(String[] args) {

		Operacion[] operaciones = {
				new Suma(),
				new Potencia(),
				new Division()
		};
		
		for (Operacion o: operaciones) {
			System.out.println(o.getClass().getSimpleName());
			System.out.println(o.ejecuta(8, 4));
			
			//Pattern Matching
			if (o instanceof Suma sum) {
				System.out.println("Suma de 2 doubles Patten Matching");
				System.out.println(sum.ejecuta(8.0, 4.0));
			}
		}
		
		
		
	}

}
