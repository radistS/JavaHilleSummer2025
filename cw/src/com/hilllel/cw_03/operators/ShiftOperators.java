package com.hilllel.cw_03.operators;

public class ShiftOperators {
    public static void main(String[] args) {
        int num = 8; // 00001000 в двійковій системі
        /*
        <<    00010000 -> 16
        main: 00001000 -> 8
        >>    00000100 -> 4
         */
        System.out.println("num << 1: " + (num << 1)); // 16 (00010000) x * 2
        System.out.println("num >> 1: " + (num >> 1)); // 4  (00000100) x / 2

        System.out.println("num << 2: " + (num << 2)); // 32 (00100000) x * 4
        System.out.println("num >> 2: " + (num >> 2)); // 2  (00000010) x / 4


        num = 15; // 00001111 в двійковій системі
        System.out.println(Integer.toBinaryString(15));
        /*
        <<    00011110 -> 16
        main: 00001111 -> 15
        >>    00000111 -> 7
         */
        System.out.println("num << 1: " + (num << 1)); // 30 (00011110)
        System.out.println(Integer.toBinaryString(15 << 1));
        System.out.println("num >> 1: " + (num >> 1)); // 7  (00000111)
        System.out.println(Integer.toBinaryString(15 >> 1));

        int negativeNum = -8;
        System.out.println("negativeNum >> 1: " + (negativeNum >> 1));  // збереження знаку
        System.out.println("negativeNum >>> 1: " + (negativeNum >>> 1)); // беззнаковий зсув

        System.out.println(Integer.toBinaryString(negativeNum));
        System.out.println(Integer.toBinaryString(negativeNum >> 1));
        System.out.println(Integer.toBinaryString(negativeNum >>> 1));
    }
}
