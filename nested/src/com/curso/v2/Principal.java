package com.curso.v2;

import java.util.Comparator;

public class Principal {
	
	public static void main(String[] args) {

		//Clase Anonima
		Comparator<String> comp = new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
	}

}
