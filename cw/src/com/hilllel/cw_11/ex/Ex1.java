package com.hilllel.cw_11.ex;

public class Ex1 {
    public static void main(String[] args) {
        long a = 0L;
        Long b = null; // --> long Long.longValue()

        if (b == a) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
    }
}
