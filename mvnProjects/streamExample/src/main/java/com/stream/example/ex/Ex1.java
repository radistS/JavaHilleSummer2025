package com.stream.example.ex;

/*
1) Фільтрація та сортування
Дано: List<String> words = List.of("Stream", "java", "Level", "mid", "MICROservice", "")
Завдання:

відкинути порожні та коротші ніж 3 символи;
привести до нижнього регістру;
відсортувати спочатку за довжиною, потім лексикографічно.
 */

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {

    public List<String> ex1(List<String> list) {
        return list.stream()
            .filter(e -> e != null && e.length() > 3)
            .map(String::toLowerCase)
            .sorted(Comparator.comparingInt(String::length).
                thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
    }

}
