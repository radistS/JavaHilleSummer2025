package com.hilllel.cw_13.ex;

public class Ex1 {

    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object o) {
        System.out.println("Object Method");
    }

    public static void method(String s) {
        System.out.println("String Method");
    }
}
