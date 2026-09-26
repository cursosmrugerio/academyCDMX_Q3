package com.curso.v1;

class Feline {

    public String type = "f ";

    public Feline() {
        System.out.print("feline "); //1
    }
}

public class Cougar extends Feline {

    public Cougar() {
        System.out.print("cougar "); //2
    }

    void go() {
        String type = "c "; //LOCAL
        System.out.print(this.type + super.type); //f f
        System.out.print(type); //c
    }

    public static void main(String[] args) {
        new Cougar().go();
    }
}