package com.hilllel.cw_27.ex;

public class Ex1 {
    public static void main(String[] args) {
         int a = 5, b = 6, c = 7;

        System.out.println(a + b +c);

        int sum = 0;
        for (int i = 0, j = 0; i < 6 && j < 5; ++i, j = i + 1) {
            sum =+ i;
            System.out.println("------------------");
            System.out.println("i >> " + i + " , j >> " + j);
            System.out.println("SUM >>> " + sum);
        }
    }
}
