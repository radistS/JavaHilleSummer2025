package com.hilllel.cw_09.coll;

public class ArrCopy {

    public static void main(String[] args) {
        int index = 2;

        String[] str1 = new String[6];

        str1[0] = "1";
        str1[1] = "2";
        str1[2] = "3";
        str1[3] = "4";
        str1[4] = "5";

        for (String s : str1) {
            System.out.print(s + " ");
        }

        String[] str2 = new String[10];

        System.arraycopy(str1, 0, str2, 0, str1.length);

        System.out.println();
        for (String s : str2) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.arraycopy(str2, index, str2, index + 1, str1.length - index);
        System.out.println();
        for (String s : str2) {
            System.out.print(s + " ");
        }
        System.out.println();

        str2[index] = "10";
        for (String s : str2) System.out.print(s + " ");


        int numMoved = str1.length - 1 - index;

        System.arraycopy(str2, index + 1, str2, index, numMoved);
        System.out.println();
        for (String s : str2) System.out.print(s + " ");

        str2[5] = null;
        System.out.println();
        for (String s : str2) System.out.print(s + " ");

    }
}
