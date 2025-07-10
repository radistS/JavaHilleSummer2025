package com.hilllel.cw_06.task;
// Напишите Java-программу для проверки является ли введенное число - числом Армстронга.
// Прежде всего, нам нужно понять, что такое число Армстронга. Число Армстронга это число,
// значение которого равно сумме цифр, из которых оно состоит, возведенных в степень, равную
// количеству цифр в этом числе. Как пример - число 371:
//    371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
// Если у вас число четырехзначное:
//    8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 8208


public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrong(14));
        System.out.println(isArmstrong(371));
        System.out.println(isArmstrong(8208));
    }

    public static boolean isArmstrong(int number) {
        int n = String.valueOf(number).length();
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, n);
            temp = temp / 10;
        }
        System.out.println(sum);
        return sum == number;

    }

    public static boolean isArmstrong(String number) {
        int n = number.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            sum += Math.pow(digit, n);
        }
        return sum == Integer.parseInt(number);
    }

    public static boolean isArmstrong(long number) {
        int n = String.valueOf(number).length();
        long sum = 0;
        long temp = number;

        while (temp > 0) {
            long digit = temp % 10;
            sum += Math.pow(digit, n);
            temp = temp / 10;
        }
        return sum == number;
    }

}
