package com.curso.v5;

import java.util.stream.Stream;
import java.util.Objects;

class Person {
	public String name;

	Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 999;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("John");
		Person p2 = new Person("Jane");
		Person p3 = new Person("Jane");
		Person p4 = new Person("Mark");
		Stream<Person> stream = Stream.of(p1, p2, p3, p4);
		long count = stream.filter(p -> p.name.startsWith("J"))
						   .distinct()
						   .peek(System.out::println)
						   .count();
		System.out.println(count);
	}
}