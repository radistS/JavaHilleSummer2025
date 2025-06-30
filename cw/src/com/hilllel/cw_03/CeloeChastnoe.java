package com.hilllel.cw_03;

public class CeloeChastnoe {
    public static void main(String[] args) {
        double d = 15.15;

        double celoe = (int) d;
        double chastnoe = d - celoe;

        System.out.println(celoe);
        System.out.println(chastnoe);

        System.out.println(d == celoe + chastnoe); // false

        char c = 'Я';

          byte b = (byte) c;
          short s = (short) c;

        System.out.println(c);
        System.out.println(b);
        System.out.println((char) b);
    }
}
