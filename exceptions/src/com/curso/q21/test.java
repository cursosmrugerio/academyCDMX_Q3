package com.curso.q21;

import java.io.IOException;
import java.util.Random;

class Exc1 extends Exception {}
class Exc2 extends Exception {}

public class test {
	
	static void a() throws Exc1 {
		
		try {
            System.out.print("Try ");
            
            double d = new Random().nextDouble();
            
            if (d > 100.0)
            	throw new Exc1();
            
        } catch (Exc1 e) {
            System.out.print("Catch ");
        } 
		
	}
	
	public static void main(String args[]) {
		System.out.println("Hola Mundo");
	}

}
