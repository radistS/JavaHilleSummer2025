package com.stream.example.ex;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/*
2) Групування за першою літерою
Дано: List<String> names = List.of("Alice","adam","Bob","brian","АЛЛА")
Завдання:

згрупувати за першою літерою (upper case, враховуючи Юнікод);
значення — відсортований список.
 */
public class Ex2 {
    public Map<String, List<String>> groupByFirstLetter(List<String> input){
        Map<String, List<String>> result = input.stream()
            .collect(
                Collectors.groupingBy(
            str -> str.toString().substring(0,1).toUpperCase(Locale.ROOT)));

            result.entrySet().stream()
            .forEach(set -> set.setValue(set.getValue().stream().sorted().toList()));

        return result;

    }
}
