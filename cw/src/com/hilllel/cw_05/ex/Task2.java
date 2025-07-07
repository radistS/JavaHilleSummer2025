package com.hilllel.cw_05.ex;

public class Task2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = a++ + --b + ++a - b--;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }
}
