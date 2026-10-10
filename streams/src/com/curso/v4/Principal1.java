package com.curso.v4;

import java.util.function.Predicate;

public class Principal1 {

	public static void main(String[] args) {
		Predicate<String> pre = s -> true;
		show(r -> false);
	}
	
	static Predicate<String> show(Predicate<String> pre) {
		return t -> true;
	}

}
