package com.hilllel.cw_17.ex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(); // JPoint, Devoxx, HolyJS
        List<String> list =
              Stream.of("JPoint",
                        "HolyJS",
                        "Devoxx",
                        "Devoxx", // false
                        "HolyJS", // false
                        "JPoint") // falsa
                .sequential()
                .filter(e -> new HashSet<String>().add(e))
//                .filter(set::add)
//                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
