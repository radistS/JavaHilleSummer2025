package com.hilllel.cw_25;

public class ExSwap {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        System.out.println("a = " + a + ", b = " + b);

        // mat
        a = a + b; // 8
        b = a - b; // 3
        a = a - b; // 5

        System.out.println("a = " + a + ", b = " + b);

        // XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a + ", b = " + b);
    }
}
