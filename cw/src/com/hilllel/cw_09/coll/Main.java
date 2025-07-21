package com.hilllel.cw_09.coll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Count c = new Count();

        System.out.println(c.getCount());
        c.add();
        c.add();
        c.add();
        System.out.println(c.getCount());

        c.remove();

        c.add();
        System.out.println(c.getCount());

        List<String> str = new ArrayList<>();


        Collections.sort(str);
        Collections.sort(str, Comparator.comparing(String::length));

    }
}
