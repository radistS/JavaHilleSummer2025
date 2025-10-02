package com.hilllel.cw_25.ex;

public class Test5 {
    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        if ((y = 1) == x) // 1 != 5 -> false
            System.out.println(y);
        else
            System.out.println(++y); // 2
    }
}
