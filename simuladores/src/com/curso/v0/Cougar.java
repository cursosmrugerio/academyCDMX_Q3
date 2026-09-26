package com.curso.v0;

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
        type = "c";
        System.out.print(type); //c
        System.out.print(this.type); //c
        System.out.print(super.type); //c
        //System.out.print(this.type + super.type);
    }

    public static void main(String[] args) {
        new Cougar().go();
    }
}