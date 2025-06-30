package com.hilllel.cw_03;

public class ContinueEx {
    public static void main(String[] args) {
        Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i : a) {
            if (i % 2 == 0) {
                continue;
            }
            if (i == 5) break;
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : a) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
