package com.hilllel.cw_17;

import java.util.List;
import java.util.stream.Stream;

public class StreamConcat {

    public static void main(String[] args) {

        Stream<Integer> int1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(e -> e % 2 == 0);
        Stream<Integer> int2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).map(e -> e * 2);

        Stream.concat(int1, int2).map(e -> e*2).forEach(System.out::println);

//        for (Integer i : List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
//            System.out.println(i);
//        }

    }

}
