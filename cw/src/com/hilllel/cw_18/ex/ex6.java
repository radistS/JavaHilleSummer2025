package com.hilllel.cw_18.ex;

import java.util.List;
import java.util.stream.Stream;

public class ex6 {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
            .parallel()
            .toList();
        list.add(10);
    }
}
