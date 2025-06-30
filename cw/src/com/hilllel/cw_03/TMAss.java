package com.hilllel.cw_03;

public class TMAss {
    public static void main(String[] args) {
        int[][][] dMass = {{
                {1, 2},
                {3, 4}
        }, {
                {5, 6},
                {7, 8}
        }};

        for (int i = 0; i < 2; i++) { // stroka
            for (int j = 0; j < 2; j++) { // stolbec
                for (int k = 0; k < 2; k++) {
                    System.out.print(dMass[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

//        System.out.println(dMass[0].length);
//
//        System.out.println("----------");
//        System.out.println(Arrays.deepToString(dMass));
//
//        int[][] mass = new int[4][4];

    }
}
