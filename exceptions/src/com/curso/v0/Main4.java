package com.curso.v0;

public class Main4 {

	public static void main(String[] args) { 

		try {
			doSomething();
		}catch (RuntimeException e)	{
			System.out.println(e);
		}
		System.out.println("End Program");
	}
	
	static void doSomething()  {

		throw new RuntimeException(); //Unchecked 

	}

}
