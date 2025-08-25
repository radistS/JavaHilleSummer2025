package com.hilllel.cw_16.steams;

import java.util.List;

public class StreamRun {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        long s = System.currentTimeMillis();
        ints.stream().peek(p -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).forEach(System.out::print);
        System.out.println();
        System.out.println("time : " + (System.currentTimeMillis() - s));
        System.out.println("--------");
        s = System.currentTimeMillis();
        ints.parallelStream().peek(p -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).forEach(System.out::print);
        System.out.println();
        System.out.println("time : " + (System.currentTimeMillis() - s));
    }
}
