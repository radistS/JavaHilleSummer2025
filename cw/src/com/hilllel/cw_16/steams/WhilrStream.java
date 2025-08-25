package com.hilllel.cw_16.steams;

import java.util.List;

public class WhilrStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        ints.stream().takeWhile(i-> i % 5 > 0).forEach(i -> System.out.print(i + " "));
        System.out.println();
        ints.stream().dropWhile(i-> i % 5 > 0).forEach(i -> System.out.print(i + " "));
        ints.stream().dropWhile(i-> i % 5 > 0).forEach(System.out::println);

//
//        ints.parallelStream()
//                .filter(i -> i % 2 == 0)
//                .forEach(i -> System.out.print(i + " "));
//
//        System.out.println();
//        System.out.println("---------------");
//
//        ints.parallelStream()
//                .sequential()
//                .filter(i -> i % 2 == 0)
//                .forEach(i -> System.out.print(i + " "));
    }
}
