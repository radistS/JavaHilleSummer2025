package com.hilllel.cw_04;

import java.util.Objects;

public class Wrappers {
    public static void main(String[] args) {

        for (int i : new int[5]) {
            System.out.println("aaa");
            System.out.print("count ");
        }

        System.out.println();

        for (Integer i : new Integer[5]) {
            System.out.println(new Wrappers().unWrapper(i));
        }

    }

    public  int unWrapper(Integer i){
        return Objects.isNull(i) ? 0 : Integer.valueOf(i);
    }
}
