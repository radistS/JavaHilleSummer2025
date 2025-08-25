package com.hilllel.cw_16.streamTask;

import com.hilllel.cw_16.streamExample.businessObject.User;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTask {

    // Перетворити список рядків у список їх довжин.
    public List<Integer> getElementLength(List<String> input){
        return input.stream()
            .map(String::length)
            .toList(); // string -> int
    }

    // Перетворити список рядків у їх довжини та видалити дублікати.
    public List<Integer> getElementLengthAndDistinct(List<String> input){
        return input
            .stream()
            .map(String::length)
            .distinct()
            .toList(); // string -> int
    }

    // Перетворити список слів у список перших літер.
    public List<Character> getFirstCharacterOfString(List<String> input){
        return input.stream()
            .map(s -> s.charAt(0))
            .collect(Collectors.toList());
    }

    // Додати лог "Обробляю: <елемент>" під час обробки.
    public List<String> addLogDuringWork(List<String> input){
        return input.stream()
            .peek(s -> System.out.println("Work with: " + s))
            .toList(); // string -> int
    }

    // Перетворити список Person у список імен.
    public List<String> getFulName(List<User> input){

        return input.stream()
            .map(s -> s.getLastName() + " " + s.getFirstName())
            .collect(Collectors.toList());
    }

    //Напишите программу, которая сдвигает все элементы массива на одну позицию влево, а первый элемент перемещает в конец массива.
    public List<String> rotateElements(List<String> input){
        return Stream.concat(
            input.stream().skip(1),
            input.stream().limit(1)
        ).toList();

    }

}
