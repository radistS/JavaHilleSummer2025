package com.hilllel.cw_09.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ALsetValues {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("_");
        list.add("_");
        list.add(null);
        list.add("_");
        list.add("_");

        System.out.println(list);

        for (String s : list) {
            if (Objects.nonNull(s))
                  System.out.println(s.hashCode());
        }

        list.remove(null);
        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("1");

        System.out.println(list1.equals(list2));
        System.out.println(list1.containsAll(list2));
        System.out.println(list1.contains("1"));

        Object[] array = list1.toArray();


        List<Integer> intList = new ArrayList<>();
        int a = 5;
        intList.add(a);
        intList.add(a);
        intList.add(a);
        intList.add(a);
        intList.add(a);
        intList.add(a);
        intList.add(a);

        Integer[] ints = new Integer[4];
        ints = intList.toArray(new Integer[10]);

        System.out.println(Arrays.toString(ints));

//        System.out.println(list);
//        list.add(3,"-");
//        System.out.println(list);
//        list.set(3, "*");
//        System.out.println(list);
//        list.set(3, null);
//        System.out.println(list);

    }
}
