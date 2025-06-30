package com.hilllel.cw_03.operators;

public class TernaryOperator {
    public static void main(String[] args) {
        int a = 15, b = 10;
        String result = (a > b) ? "a більше b" : "a не більше b";
        System.out.println(result); // "a не більше b"


        System.out.println((a > b) ? a : b); // max from 2 dig
        System.out.println((a < b) ? a : b); // min from 2 dig
        System.out.println((2 < 3) ? 2 : 3); // min from 2 dig
    }
}


/*
(boolean) ? value1 : value2:

(true) -> value1
(false) -> value2
 */


// double taxP = (boolean1) ? value1 : (boolean2) ? value2 : value3;
// boolean1 -> (0 .. 10000}
// boolean2 -> (10000 .. 25000}
