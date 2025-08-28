package com.hilllel.cw_17;

import java.util.Random;

public class RandGenerator {

//    Генерация случайных чисел:
//    Создай поток, который генерирует 5 случайных чисел от 1 до 100.

    public static void main(String[] args) {

        Random r = new Random();
        r.ints(1, 100).limit(5).forEach(System.out::println);
    }

}
