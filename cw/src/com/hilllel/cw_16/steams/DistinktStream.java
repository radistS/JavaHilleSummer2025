package com.hilllel.cw_16.steams;

import java.util.List;

public class DistinktStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,1,2,1,2,1,2);
        ints.stream().distinct().forEach(i -> System.out.print(i + " "));

    }
}
