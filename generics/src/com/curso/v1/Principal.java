package com.curso.v1;

import java.util.*;

class Empleado{
}

public class Principal {

	public static void main(String[] args) {
		
		Map<Integer,String> empleados = new HashMap<Integer,String>();
		
		empleados.put(1, "Patrobas");
		//empleados.put(5.0, new StringBuilder("Epeneto"));
		//empleados.put('a', new Empleado());
		
		System.out.println(empleados.get(1));
		System.out.println(empleados.get(5.0));
		System.out.println(empleados.get('a'));
		
		List<StringBuilder> nombres = new ArrayList<>();

	}

}
