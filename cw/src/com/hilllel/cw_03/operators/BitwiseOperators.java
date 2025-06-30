package com.hilllel.cw_03.operators;

public class BitwiseOperators {
    public static void main(String[] args) {
        int x = 5;   // 0101 в двійковій системі
        int y = 3;   // 0011 в двійковій системі


        /*
        (AND)
        x -> 0101
        y -> 0011
        ---------
             0001 -> 1
         */
        System.out.println("x & y: " + (x & y)); // 0101 & 0011 = 0001 (1)

        /*
        (OR)
        x -> 0101
        y -> 0011
        ---------
             0111 -> 7
         */
        System.out.println("x | y: " + (x | y)); // 0101 | 0011 = 0111 (7)


          /*
        (XOR)
        x -> 0101
        y -> 0011
        ---------
             0110-> 6
         */
        System.out.println("x ^ y: " + (x ^ y)); // 0101 ^ 0011 = 0110 (6)

      /*
        (COMPLEMENT)
        x -> 00000000 00000000 00000000 00000101
        ----------------------------------------
             11111111 11111111 11111111 11111010 -> -6
         */
        System.out.println("~x: " + (~x));       // побітове заперечення
    }
}


