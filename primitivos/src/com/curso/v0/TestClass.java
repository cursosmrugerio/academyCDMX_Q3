package com.curso.v0;

class Base {
	public long getValue() {
		return 1;
	} 
}

class Base2 extends Base {
	public long getValue() {
		return 2;
	} 
}

public class TestClass {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue()); // 3
	}
}