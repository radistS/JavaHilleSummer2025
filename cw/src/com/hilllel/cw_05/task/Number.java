package com.hilllel.cw_05.task;

public class Number {
    /*
       Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
     */
    public static void main(String[] args) {
        int[] mass = {1123, 4526, 7789, 112, 334, 9876, 10203, 111, 909, 321};
        for (int j : mass) {
            if (hisUnique(j)) {
                System.out.println(j);
                break;
            }
        }
    }

    private static boolean hisUnique(int number) {
        boolean[] isUnique = new boolean[10];
        while (number > 0) {
            int remainder = number % 10; // 3
            if (isUnique[remainder]) {
                return false;
            }
            isUnique[remainder] = true;
            number /= 10;
        }
        return true;
    }
}
