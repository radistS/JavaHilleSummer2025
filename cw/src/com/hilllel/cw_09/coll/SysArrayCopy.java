package com.hilllel.cw_09.coll;

import java.util.Arrays;

public class SysArrayCopy {
    public static void main(String[] args) {

        String[] str1 = {"1","2","3","4","5","6","7","8"};
        String[] str2 = new String[15];

        System.out.println(Arrays.toString(str1));
        System.out.println(Arrays.toString(str2));

        System.arraycopy(str1, 0, str2, 0, str1.length);
//        System.arraycopy(str1, 0, str2, 0, 5);

        System.out.println(Arrays.toString(str1));
        System.out.println(Arrays.toString(str2));

        System.arraycopy(str2, 3, str2, 4, str2.length - 4);

        System.out.println(Arrays.toString(str2));
        str2[3] = "100";

        System.out.println(Arrays.toString(str2));
//
//        int size = 9;
//        int index = 3;
//        int move = size - index - 1;
//
//        System.arraycopy(str2, index + 1, str2, index, move);
//        System.out.println(Arrays.toString(str2));
//        str2[--size] = null;
//        System.out.println(Arrays.toString(str2));
//
//
//        // index = 3;
//        for (int i = index; i < str2.length-1; i++) {
//            str2[i - 1] = str2[i];
////            str2[i] = null;
//        }
//
//        System.out.println(Arrays.toString(str2));
//
//        for (int i = index; i <= size; i++) {
//            str2[i - 1] = str2[i];
//            str2[i] = null;
//        }
//        System.out.println(Arrays.toString(str2));
    }
}
