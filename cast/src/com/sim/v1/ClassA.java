package com.sim.v1;

class ClassB extends ClassA{}
class ClassC extends ClassA{}

class ClassA {

	public static void main(String[] args) {
		ClassA p0 = new ClassA();
		ClassB p1 = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();
		
		p0 = p1;
		
		System.out.println(p0.getClass().getSimpleName()); //B
		
		p2 = (ClassC)p0;
		
		

	}

}
