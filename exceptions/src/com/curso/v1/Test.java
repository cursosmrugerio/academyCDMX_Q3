package com.curso.v1;

public class Test {

	public static void main(String[] args) {

		try (AutoCloseable resource = () -> System.out.print("Resource closed ")) {
			System.out.print("Resource used ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
//Resource used Resource closed