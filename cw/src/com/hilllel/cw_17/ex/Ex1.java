package com.hilllel.cw_17.ex;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        Integer i = 10;
        List<Integer> list = new ArrayList<>();
        list.add(i); // 10
        list.add(i *= 2); // i = i * 2 -> 20
        list.add(i); // 20
        System.out.println(list);
        list.removeIf(g -> g == 10);
        System.out.println(list);
    }
}
