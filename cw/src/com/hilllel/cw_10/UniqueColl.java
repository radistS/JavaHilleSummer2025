package com.hilllel.cw_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueColl {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("AL : " + list);

        Set<String> set = new HashSet<>(list);

        System.out.println(set);
    }
}
