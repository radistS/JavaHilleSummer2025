package com.hilllel.cw_03;

public class TypePrived {
    public static void main(String[] args) {
        byte a = 120; //127
        System.out.println(a);
        a += 2; // 122
        System.out.println(a);
        int b = a + 10; // 122 + 10 = 132
        System.out.println(b); // int
        System.out.println((byte) b); // >127 -> error
        System.out.println("-----------");
//        Byte a1 = 120;
//        System.out.println(a1);
//        System.out.println(a1 + 10);
//
//        byte a2 = 10;
//        System.out.println(a2);
//        int a3 = a2;
//        System.out.println(a3);
//
//            Double d1 = 4d;
//            Double d2 = 2d;
//            Double res = (d1/d2);
//            System.out.println(res.intValue());
//            System.out.println(d1 / d2);
//
//
//        System.out.println(res.compareTo(1d)); // 2 > 1 ->  1
//        System.out.println(res.compareTo(2d)); // 2 = 0 ->  0
//        System.out.println(res.compareTo(3d)); // 2 < 1 -> -1
//
//        System.out.println(Integer.valueOf("234"));
//        System.out.println(Integer.valueOf("01234"));
//        System.out.println(Integer.valueOf("0f1234"));

    }

}

