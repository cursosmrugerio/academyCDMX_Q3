package com.curso.v6;

interface IFun {
	int calculate(int i1, int i2);
}

public class Test {
	public static void main(String[] args) {
		
		
		IFun f = (i1, i2) -> i1 + i2; // line 1
		
		IFun g = (i1, i2) -> i1 * i2; // line 3
		System.out.println(g.calculate(8, 4)); // line 4
		
		int i1 = 1, i2 = 2; // line 2
		
		System.out.println(f.calculate(8,4));
	}
}