package com.curso.v0;

public class Main3 {

	public static void main(String[] args) { 

		doSomething();
				
		System.out.println("End Program");
	}
	
	static void doSomething()  {

		throw new RuntimeException(); //Unchecked 

	}

}
