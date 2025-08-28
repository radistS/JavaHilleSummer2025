package com.hilllel.cw_17.stream_cont;

import java.util.stream.Stream;

public class FindStream {
    public static void main(String[] args) {
//        Integer any = Stream.of(1,5,4,2,9,1,2,3,5,6,1,5)
//            .parallel()
//            .findAny().get();
//        System.out.println(any);

//        Integer first = Stream.of(1,3,4,2,9,1,2,3,5,6,1,5)
//            .parallel()
//               .findFirst().get();

//        System.out.println(first);
//

//        System.out.println(Stream.of(1, 3, 2, 2,  1, 2, 3)
        System.out.println(Stream.of(1, 3, 2, 2,  1, 2, 3, 9)
                .allMatch(e -> e < 4));



    }
}
