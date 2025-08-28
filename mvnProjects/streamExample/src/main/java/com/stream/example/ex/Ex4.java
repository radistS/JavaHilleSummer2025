package com.stream.example.ex;

/*
4) Топ-N слів
Продовження: задачі 3.
Завдання: отримати топ-10 найчастіших слів, відсортованих за спаданням частоти.
 */

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Ex4 {

    public List<String> topTen( Map<String, Long> input){
        return input.entrySet()
            .stream()
            .sorted( Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                .reversed()
//                .thenComparing(Map.Entry::getKey)
                )
            .limit(10)
            .map(Map.Entry::getKey)
            .toList();

    }

}
