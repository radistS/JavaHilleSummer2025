package com.hilllel.cw_03.task;

public class Task4 {
    public static void main(String[] args) { // -128 .. 127
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        Integer c = 256;
        Integer d = 256;
        System.out.println(c == d);
        System.out.println(c.equals(d));

        Short a1 = 127;
        Short b2 = 127;
        System.out.println(a1 == b2);
    }
}
