package com.hilllel.cw_10;

import java.util.ArrayList;
import java.util.List;

public class ListOf {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("s");
        list.add("s");
        list.add("s");
        list.add("s");

        System.out.println(list);


        List<String> unmodList = List.of("a", "b", "c");

        System.out.println(unmodList);

        unmodList.add("x");

    }



}
