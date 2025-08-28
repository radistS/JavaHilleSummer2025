package com.stream.example.ex;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
14) Бакетизація віку
Дано: List<Integer> ages.
Завдання: розподілити по діапазонах 0–17, 18–25, 26–35, 36–50, 51+.
 */
public class Ex6 {
    public Map<String, Long> bucketsMap (List<Integer> input){
        return input.stream().collect(Collectors.groupingBy(
            this::bucket, Collectors.counting()));
    }

    private String bucket(int age){
        if (age <= 17) return "0–17";
        else if (age <= 25) return "18–25";
        else if (age <= 35) return "26–35";
        else if (age <= 50) return "36–50";
        else return "51+";
    }
}
