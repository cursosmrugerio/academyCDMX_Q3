package com.curso.v0;

public class Main {

	public static void main(String[] args) {

		doSomething();
		
		System.out.println("End Program");
	}
	
	static void doSomething() {
		try {
			throw new Exception(); //Checked
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
