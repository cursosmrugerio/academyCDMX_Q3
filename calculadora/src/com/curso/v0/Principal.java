package com.curso.v0;

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
			
			if (o instanceof Suma) {
				System.out.println("Suma de 2 doubles");
				System.out.println(((Suma)o).ejecuta(8.0, 4.0));
			}
		}
		
		
		
	}

}
