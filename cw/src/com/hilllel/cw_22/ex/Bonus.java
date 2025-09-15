package com.hilllel.cw_22.ex;

import java.util.Arrays;
import java.util.List;

public class Bonus {
    public static void main(String[] args) {
        String[] str = new String[10];
        str[0] = "FIRST";
        System.out.println(Arrays.asList(str).size());
        System.out.println(Arrays.asList(str));

        System.out.println("-----------");

        Integer[] num = new Integer[10];
        num[5] = 127;
        List<Integer> list = Arrays.asList(num);

        System.out.println(Arrays.asList(num).size());
        System.out.println(Arrays.asList(num));
    }
}
