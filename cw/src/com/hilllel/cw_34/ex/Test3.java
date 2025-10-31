package com.hilllel.cw_34.ex;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Set<Number> set = new HashSet<>();
        System.out.println(set.add(1)); // integer
        System.out.println(set.add(1L)); // long
        System.out.println(set.add(1.0)); // double
        System.out.println(set.size());

        System.out.println(set);
        for (Number num : set){
            System.out.println(num.getClass());
        }

    }
}
