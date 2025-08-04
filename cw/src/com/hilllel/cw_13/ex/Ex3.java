package com.hilllel.cw_13.ex;

public class Ex3 {
    public static void main(String[] args) {
        double a = 295.04; // int -> byte -> 295 - 256 -> 39
        int b = 300; // 300 - 256 -> 44
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + " " + d);
    }
}
