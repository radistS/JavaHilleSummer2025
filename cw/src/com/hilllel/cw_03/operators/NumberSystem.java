package com.hilllel.cw_03.operators;

public class NumberSystem {

    public static void main(String[] args) {
        int a = 20;

        // 10
        System.out.println(" (10) -> " + a);
        // 2
        System.out.println(" (2) -> " + Integer.toBinaryString(a));
        // 8
        System.out.println(" (8) -> " + Integer.toOctalString(a));
        // 16
        System.out.println(" (16) -> " + Integer.toHexString(a));
    }
}
