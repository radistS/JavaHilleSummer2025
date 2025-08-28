package com.stream.example.ex;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
5) Розплющення вкладених колекцій
Дано: List<List<Integer>> matrix.
Завдання: розплющити у Stream<Integer>, видалити дублікати, відсортувати.


 */
public class Ex5 {
    public List<String> toFlatMap(List<List<String>> lists){
        return lists.stream()
            .flatMap(List::stream)
            .distinct()
            .sorted()
            .toList();

    }

}
