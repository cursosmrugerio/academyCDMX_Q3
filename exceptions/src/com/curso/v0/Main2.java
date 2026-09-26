package com.curso.v0;

public class Main2 {

	public static void main(String[] args) { // throws Exception {

		try {
			doSomething();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("End Program");
	}
	
	static void doSomething() throws Exception {

		throw new Exception(); //Checked

	}

}
