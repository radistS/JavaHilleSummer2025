package com.hilllel.cw_16.steams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollect {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 2, 4, 3, 4, 5, 6, 7, 8, 9, 10);
//        ints.forEach(System.out::print);
//        System.out.println();
//        System.out.println("------");
//        for (Integer i: ints){
//            System.out.print(i);
//        }

        ints = ints.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println();
        ints.forEach(System.out::print);

        Set<Integer> i = List.of(1, 2, 2, 4, 3, 4, 5, 6, 7, 8, 9, 10).stream().filter(f -> f % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println();
        i.forEach(System.out::print);
    }
}
