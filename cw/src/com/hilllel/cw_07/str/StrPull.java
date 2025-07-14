package com.hilllel.cw_07.str;

public class StrPull {

    public static void main(String[] args) {
        String a = "one";
        String b = "one";
        String c = new String("one");

        System.out.println(a == b); // --> true
        System.out.println(a.hashCode());
        System.out.println(c == a); // --> false
        System.out.println(a.equals(c)); // --> true
        System.out.println(c.hashCode());

        c = c.intern();

        System.out.println(" after intern() ...");
        System.out.println(a == b); // --> true
        System.out.println(c == a); // --> true
    }

}
