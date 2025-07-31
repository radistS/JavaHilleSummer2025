package com.hilllel.cw_12.ex;

public class Ex1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        String s = "abc";
        sb.reverse().append("d");
        s.toUpperCase().concat("d"); // immutable
        System.out.println("." + sb + ". ." + s + ".");
        System.out.println("." + sb + ". ." + s.toUpperCase().concat("d") + ".");
    }
}
