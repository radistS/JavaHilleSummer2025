package com.hilllel.cw_10.task;

import java.util.Stack;

/*
Реверс слов в предложении:

Напишите программу, которая принимает предложение и использует Stack для реверса порядка слов в этом
предложении. Например, "Hello World" станет "World Hello".
 */
public class task3 {

    public static void main(String[] args) {
        System.out.println(reverse("Hello World"));

    }

    public static String reverse(String str) {
        // split
        String[] s = str.split(" ");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
