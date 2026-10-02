package com.curso.v0;

class Ot {
    enum Colors {
        RED, GREEN, BLUE, YELLOW, BLACK
    };
}
public class Test {
    public static void main(String[] String) {
        for (Ot.Colors c : Ot.Colors.values()) {
            if (Ot.Colors.RED.equals(c)) {
                System.out.print("red ");
            }
            if (c == Ot.Colors.GREEN) {
                System.out.print("green ");
            }
            if (c.equals("BLUE")) {
                System.out.print("blue ");
            }
        }
    }
}