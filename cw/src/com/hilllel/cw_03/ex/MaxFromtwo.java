package com.hilllel.cw_03.ex;

public class MaxFromtwo {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }

        System.out.println((a > b) ? a : b);

        System.out.println(Integer.max(a, b));


    }

}
