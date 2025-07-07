package com.hilllel.cw_05.ex;

public class Task4 {
    public static void main(String[] args) {
        int x = 10, y = 15;
        String result = (x > y)
            ? "x больше y"
            : ((x < y)
                ? "x меньше y"
                : "x равен y");
        System.out.println(result);
    }
}
