package com.hilllel.cw_10.task;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
Удаление дубликатов из списка:

Дана коллекция ArrayList с повторяющимися элементами. Напишите программу, которая удаляет все
 дубликаты из списка, сохраняя порядок элементов, и выводит обновленный список.
 */
public class task1 {

    public static void main(String[] args) {

        List<Integer> input = List.of(1,1,2,3,4,5,5,6,7,6,7,8,7,6,7);
        Set<Integer> set = new HashSet<>();
        set.addAll(input);

        Set<Integer> lset = new LinkedHashSet<>();
        lset.addAll(input);
        System.out.println(set);
        System.out.println(lset);

    }

}
