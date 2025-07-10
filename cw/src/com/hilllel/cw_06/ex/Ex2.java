package com.hilllel.cw_06.ex;

public class Ex2 {
    public static void main(String[] args) {
        int x = 0;
        while (x++ < 10){}
        String message = x > 10 ? "Grather than" : String.valueOf(false);

        // if (x > 10) {
        // } else {
        // }
        System.out.println(message+","+x);
    }
}
