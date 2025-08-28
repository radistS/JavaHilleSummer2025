package com.hilllel.cw_17.stream_cont;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> iSet = Stream.of(1, 3, 0, 4, 2, 9, 12, 32, 4, 54, 54, 54,543 , 5, 4, 6, 8, 9, 8, 6, 1, 5)
            .collect(Collectors.toSet());
        for (Integer i : iSet) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(iSet.getClass().getName());
    }

}
