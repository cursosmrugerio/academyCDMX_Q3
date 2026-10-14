package com.curso.q22;

public class Truthy {
	
	public static void main(String[] args) {
		int x = 7;
		
		//assert (x==6)?"x==6":"x!=6";
		
		assert x == 6 : "x!=6";
		
		System.out.println("End Progam: "+x);
	}

}
