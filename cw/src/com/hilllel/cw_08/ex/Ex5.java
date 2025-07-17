package com.hilllel.cw_08.ex;

public class Ex5 {
    private final static String RESULT ="2cfalse";
    public static void main(String[] args) {
        String a = "";
        a += 2;     // new String
        System.out.println(a);
        a += 'c';   // new String
        System.out.println(a);
        a += false; // new String
        System.out.println(a);
//        a = a.intern();

        System.out.println();
        if (a == RESULT) System.out.println("==");
        if (a.equals(RESULT)) System.out.println("equals");
    }
}
