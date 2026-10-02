package com.curso.v0;

import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] argv) {
        LocalDate date = LocalDate.of(1997, Month.MAY, 50);
        System.out.println(date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth());
    }
}