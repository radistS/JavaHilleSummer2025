package com.hilllel.cw_10.task;

/*
Поиск пересечения двух массивов:

Напишите программу, которая находит пересечение двух массивов целых чисел, используя HashSet. Ваша
программа должна вернуть новый массив с элементами, которые присутствуют в обоих массивах.

 */

import java.util.HashSet;

public class task4 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr1 = {6,7,8,9,11,12,12};

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println(set);
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set2.add(arr1[i]);
        }
        System.out.println(set2);

        HashSet<Integer> result = new HashSet<>();
        for (int s : set2) {
            if (set.contains(s)) {
                result.add(s);
            }
        }
        System.out.println(result);

        set2.retainAll(set);

        System.out.println(set);
        System.out.println(set2);
    }

}
