package com.hilllel.cw_02;

public class Input {
    public static void main(String[] args) {
        int summ = 0;
        System.out.println("input array size : " +
                args.length);
        for (String str : args) {
            System.out.println(str);
            int intValue = Integer.parseInt(str);
//            summ = summ + i;
            summ +=intValue;
        }
        System.out.println("----------");
        System.out.println("result : " + summ);
    }

}
