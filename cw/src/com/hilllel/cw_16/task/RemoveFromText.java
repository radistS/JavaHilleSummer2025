package com.hilllel.cw_16.task;


import java.util.Arrays;
import org.w3c.dom.ls.LSOutput;

// Из текста удалить все слова заданной длины, начинающиеся c заданой буквы.
public class RemoveFromText {

    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал знязь Василий " +
            "зтихо Анне Павловне почему он особенно умного Мы зосле поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {
        String l = "з";
        Integer i = 5;

        Arrays.stream(TEXT.split(" "))
            .filter(s -> s.length() != i && !s.startsWith(l))
            .forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.println("-------");

        Arrays.stream(TEXT.split(" "))
            .filter(s -> !(s.length() != i && !s.startsWith(l)))
            .forEach(System.out::println);

    }
}
