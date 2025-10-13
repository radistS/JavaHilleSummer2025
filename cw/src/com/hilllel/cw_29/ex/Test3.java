package com.hilllel.cw_29.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iter = list.iterator();
//        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.printf(iter.next() + " ");
        }
    }
}
