package com.curso.v4;

import java.util.function.Predicate;
class Foo {
    int i;
    Foo(int i) {
        this.i = i;
    }
}

public class Test {
	
	static boolean compare(Foo foo, Predicate<Foo> predicate) {
		// new Foo(1) -> (true or true) and false 
        return predicate.test(foo); //UNICO PUNTO DONDE SE EJECUTA LA LAMBDA
    }

	public static void main(String[] args) {
		Predicate<Foo> p = f -> f.i > 0; // line 1
		
		Predicate<Foo> pred1 = p.or(f -> f.i > 0);
		
		Predicate<Foo> pred2 = pred1.and(f -> f.i < 0);
		
		boolean b = compare(new Foo(1), pred2); // line 3
		
	}

}
