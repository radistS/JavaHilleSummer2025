package com.hilllel.cw_10.ex;

import java.util.ArrayList;
import java.util.List;

public class EX3 {
    public static void main(String[] args) {

        Integer i = 3;
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add(String.valueOf(i));
        list.add(String.valueOf(3));

        for (Object s : list) {
            System.out.print(s + " ");
//            break;
        }
    }
}
