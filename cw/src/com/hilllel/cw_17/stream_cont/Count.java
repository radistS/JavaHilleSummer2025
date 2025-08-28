package com.hilllel.cw_17.stream_cont;

import java.util.stream.Stream;

public class Count {
    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).
                filter(e-> e >= 5).count()
        );
    }
}
