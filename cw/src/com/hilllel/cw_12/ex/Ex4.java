package com.hilllel.cw_12.ex;

import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        String[] name = {"Sasha", "Ivan", "Masha"};
        List<String> names = Arrays.asList(name);
        System.out.println(name.length);
        names.set(0, "Kate");
        System.out.println(name[0]);
//        names.add("Vasil");
//        System.out.println(name.length);
//        System.out.println(name[0]);
//        System.out.println(name[1]);
//        System.out.println(name[2]);
//
//        System.out.println(names);
//        System.out.println(Arrays.deepToString(name));
//
//        name[0] = " ";
//        name[1] = " ";
//        name[2] = " ";
//
//        System.out.println(names);
//        System.out.println(Arrays.deepToString(name));
    }
}
