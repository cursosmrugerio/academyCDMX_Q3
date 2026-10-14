package com.curso.v0;

class BaseClass {
	
	BaseClass(int x){
		super();
		System.out.println("Constructor BaseClass"); //1
	}
	
}

class SubClass extends BaseClass {
	
	SubClass(){
		//DEBE SER LA PRIMERA LINEA super OR this
		super(10);
		System.out.println("Constructor SubClass"); //2
	}

	public static void main(String[] args) {
	
		SubClass sb = new SubClass();
		
		System.out.println("Hola Mundo"); //3
		
	}
	
}
