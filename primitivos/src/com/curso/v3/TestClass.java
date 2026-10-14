package com.curso.v3;

class Base {
	public CharSequence getValue() {
		return null;
	} 
}

class Base2 extends Base {
	@Override
	public String getValue() {
		return null;
	} 
}

public class TestClass {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue()); // 3
	}
}