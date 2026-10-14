package com.curso.v2;

class SuperBaseClass{
	public void print(String s) {
		System.out.println("SuperBaseClass :" + s);
	} 
}

class BaseClass extends SuperBaseClass{
	public void print(String s) {
		System.out.println("BaseClass :" + s);
		super.print(s);
	} 
}

class SubClass extends BaseClass {
	public void print(String s) {
		System.out.println("SubClass :" + s); 
		super.print(s);
	}

	public static void main(String args[]) {
		SubClass sc = new SubClass();
		sc.print("location");
	}
}