package com.hilllel.cw_04;

public class Str {
    public static void main(String[] args) {
        String st1 = "St1";
        String st2 = new String("St1");

        System.out.println(st1 == st2);

        st2 = st2.intern();

        System.out.println(st1 == st2);
    }
}
