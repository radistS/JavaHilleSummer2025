package com.hilllel.cw_07.task;

public class LuckyNumber {
    public static void main(String[] args) {
      String number = "000256985";
        System.out.println(isLucky("0083313"));

    }

    private static boolean isLucky(String  number) {
        if (number.length() % 2 != 0) {
            return false;
        }

        int left = 0, right = 0;

        for (int i = 0; i <= (number.length() - 1) / 2 ; i++) {
            left += Integer.parseInt(number.charAt(i) + "");
            right += Integer.parseInt(number.charAt(number.length() -i - 1) + "");
        }
        System.out.println("right  --> " + right );
        System.out.println("left  --> " + left );

       return left == right;

    }

}
