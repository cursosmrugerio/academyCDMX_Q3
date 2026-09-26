package com.curso.v1;

public class Main {

    public static void main(String[] args) throws Exception {
        doSomething();
    }

    private static void doSomething() throws Exception {
        System.out.println("Before if clause");

        if (Math.random() > 0.5) {
            throw new Exception();
        }

        System.out.println("After if clause");
    }
}

//Before if clause
//After if clause

//Before if clause
//**DESBORDA**
