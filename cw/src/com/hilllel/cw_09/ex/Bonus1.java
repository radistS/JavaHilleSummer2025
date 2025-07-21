package com.hilllel.cw_09.ex;

public class Bonus1 {

    static int i;
    static int j;

    public static void main(String[] args) {
        i = 3;
        j = 6;
        run(i++, --j);
    }

    private static void run(int x, int y) {
        System.out.println("i =  " + i);
        System.out.println("j =  " + j);
        System.out.println("x =  " + x);
        System.out.println("y =  " + y);
    }
}
