package com.hilllel.cw_06.task;

import java.util.Arrays;
import java.util.Scanner;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,4,5,4,5};
        int targer = 4;

      int[] result = removeOccurrences(numbers, targer);

      System.out.println(Arrays.toString(result));
    }

    public static int[] removeOccurrences(int[] arr, int x) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                arr[j++] = arr[i];
            }
        }
        return Arrays.copyOf(arr, j);
    }
}
