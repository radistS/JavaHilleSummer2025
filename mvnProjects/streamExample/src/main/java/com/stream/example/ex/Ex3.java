package com.stream.example.ex;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
3) Частоти слів у тексті
Дано: довільний String text.
Завдання: зібрати Map<String, Long> частот слів, ігноруючи пунктуацію.
 */
public class Ex3 {

    public Map<String, Long> wordCounting(String input){
        Pattern p = Pattern.compile("//W+");

        return Arrays.stream(input
                .replaceAll("\\p{Punct}", "")
                .toLowerCase()
                .split(" "))
            .filter(s -> !s.isEmpty())
            .map(s -> s.toLowerCase(Locale.ROOT))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

    }

}
