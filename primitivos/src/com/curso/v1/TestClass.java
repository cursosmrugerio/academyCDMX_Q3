package com.curso.v1;

class Base {
	public Number getValue() {
		return 1;
	} 
}

class Base2 extends Base {
	@Override
	public Integer getValue() {
		return 2;
	} 
}

public class TestClass {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue()); // 3
	}
}