package com.curso.v1;

public class Test1 {

	public static void main(String[] args) {
		
		AutoCloseable resource0 = () -> System.out.print("Resource closed ");

		try (AutoCloseable resource = () -> System.out.print("Resource closed ")) {
			System.out.print("Resource used ");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
//Resource used Resource closed