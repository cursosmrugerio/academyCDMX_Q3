package com.curso.v0;

import java.util.*;

class Empleado{
}

public class Principal {

	public static void main(String[] args) {
		
		Map empleados = new HashMap();
		
		empleados.put(1, "Patrobas");
		empleados.put(5.0, new StringBuilder("Epeneto"));
		empleados.put('a', new Empleado());
		
		System.out.println(empleados.get(1));
		System.out.println(empleados.get(5.0));
		System.out.println(empleados.get('a'));
		
		List nombres = new ArrayList();

	}

}
