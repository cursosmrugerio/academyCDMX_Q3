package com.sim.v0;

class ClassB extends ClassA{}
class ClassC extends ClassA{}

class ClassA {

	public static void main(String[] args) {
		ClassA p0 = new ClassA();
		ClassB p1 = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();
		
		
		//p1 = p2;
		p2 = (ClassC)p4;
		
		//p2 = p4;
		
		p1 = (ClassB)p3;
		p0 = p1;
		
		//if (p1 instanceof ClassC){
			//p2 = (ClassC)p1;
		//}
	}

}
