package com.hilllel.cw_29.ex;

public class Test5 {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;

        System.out.println(true ? x : 0); // char
        System.out.println(false ? i : x); // int
        System.out.println(false ? 0 : x); // char
    }
}
