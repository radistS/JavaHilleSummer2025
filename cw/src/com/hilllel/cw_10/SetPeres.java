package com.hilllel.cw_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Поиск пересечения двух массивов:

Напишите программу, которая находит пересечение двух массивов целых чисел, используя HashSet. Ваша
программа должна вернуть новый массив с элементами, которые присутствуют в обоих массивах.

 */
public class SetPeres {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 4};
        Integer[] array2 = {2, 3, 5, 7};

        Set<Integer> set = new HashSet<>(Arrays.asList(array1));

        System.out.println(set);

        Set<Integer> result = new HashSet<>();

        for (Integer i : array2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }

        System.out.println(result);
    }
}
