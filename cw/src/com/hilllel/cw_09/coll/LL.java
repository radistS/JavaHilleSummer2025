package com.hilllel.cw_09.coll;

import java.util.LinkedList;
import java.util.List;

public class LL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println(list.size());

        list.add("swww1");
        list.add("swww2");
        list.add("swww3");
        list.add(1,"sww1_1");

        list.removeFirst();
        list.removeLast();

        System.out.println(list);

        System.out.println(list.get(0));


    }
}
