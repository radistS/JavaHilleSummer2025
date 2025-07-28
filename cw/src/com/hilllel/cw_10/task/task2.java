package com.hilllel.cw_10.task;

import java.util.LinkedList;
import java.util.List;

/*
Ротация списка:

Напишите программу, которая принимает LinkedList и поворачивает его на заданное количество позиций
вправо. Например, для списка [1, 2, 3, 4, 5] и сдвига на 2 позиции результатом будет [4, 5, 1, 2, 3].

 */
public class task2 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));
        System.out.println(list);
        System.out.println(rotate(list, 2));

    }

    public static LinkedList<String> rotate(LinkedList<String> list, int k ) {
        int n = list.size();
        if (k == 0 || n == 0) return list;
        k = k % n;
        if (k == 0) return list;
        for (int i = 0; i < k; i++) {
            list.addFirst(list.removeLast());
        }
        return list;

    }

}
