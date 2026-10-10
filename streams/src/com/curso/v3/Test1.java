package com.curso.v3;
import java.util.function.*;
public class Test1 {
    public static void main(String[] args) {
        Predicate<String> p = (s) -> s.length() > 5;

        //CLASE::INSTANCE METHOD
        Function<String, Integer> f = String::length;
        //Function<String, Integer> f1 = s -> s.lenght();
        
        Consumer<String> c = (s) -> System.out.println(s.toUpperCase());

        Supplier<String> s = () -> "Hello, world!";

        String testString = "functional";
        
        //OBJECT::INSTANCE METHOD
        Supplier<Integer> sup = testString::length;
        //Supplier<Integer> sup1 = () -> testString.length();

        System.out.println(p.test(testString)); //true
        System.out.println(f.apply(testString)); //10
        System.out.println(sup.get()); //10
        c.accept(testString); //FUNCTIONAL
        System.out.println(s.get()); //Hello, world
    }
}
