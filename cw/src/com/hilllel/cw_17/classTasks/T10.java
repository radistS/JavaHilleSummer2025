package com.hilllel.cw_17.classTasks;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

// 10.  Существует текст и список слов. Для каждой буквы из заданного списка найти,
// сколько раз оно встречается , и рассортировать слова по
// убыванию общего количества вхождений.
public class T10 {

    public static void main(String[] args) {
        String strR = normalizeText(StringTest.TEXT_R);
        String strE = normalizeText(StringTest.TEXT_E);

        Map<String, Long> collect = Arrays.stream(strR.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        TreeMap<String, Long> map = new TreeMap<>(collect);
        System.out.println(map);

        System.out.println();

        System.out.println(Arrays.stream(StringTest.TEXT_R
//                .replaceAll("\\p{Z}", "")
                .replaceAll("\\p{P}", "")
                .toLowerCase()
                .split(""))
            .flatMapToInt(String::chars)
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    }

    private static String normalizeText(String text) {
        return text.replaceAll("\\p{Z}", "") // удаление пробелов
        .replaceAll("\\p{P}", "") // удаление знаков припинапия
        .toLowerCase(); // перевод в нижний регистр
    }

}
