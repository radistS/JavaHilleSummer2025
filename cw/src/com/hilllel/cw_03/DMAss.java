package com.hilllel.cw_03;

import java.util.Arrays;

public class DMAss {
    public static void main(String[] args) {
//        int[][] dMass = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        for (int i = 0; i < 3; i++) { // stroka
//            for (int j = 0; j < 3; j++) { // stolbec
//                System.out.print(dMass[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(dMass[0].length);
//
//        System.out.println("----------");
//        System.out.println(Arrays.deepToString(dMass));

        boolean[][] mass = new boolean[4][4];
        for (int i = 0; i < 4; i++) { // stroka
            for (int j = 0; j < 4; j++) { // stolbec
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }

        String[][] massStr = new String[4][4];
        for (int i = 0; i < 4; i++) { // stroka
            for (int j = 0; j < 4; j++) { // stolbec
                System.out.print(massStr[i][j] + " ");
            }
            System.out.println();
        }

        int[][] massInt = new int[4][4];
        for (int i = 0; i < 4; i++) { // stroka
            for (int j = 0; j < 4; j++) { // stolbec
                System.out.print(massInt[i][j] + " ");
            }
            System.out.println();
        }

    }
}
