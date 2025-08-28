package com.hilllel.cw_17;

import java.util.stream.Stream;

public class ParStream {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().forEach(s -> System.out.print(s + " "));
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().sequential().forEach(s -> System.out.print(s + " "));


        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
            .filter(a -> a % 2 == 0)
            .parallel().forEach(s -> System.out.print(s + " "));



    }

}
