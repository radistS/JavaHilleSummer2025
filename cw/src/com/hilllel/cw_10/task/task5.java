package com.hilllel.cw_10.task;
/*
Проверка сбалансированности скобок
Описание. Используя Stack<Character>, проверить, правильно ли в строке расставлены скобки трёх типов: (), {}, [].
Пример. "{[()()]}" → true; "{[(])}" → false.
 */
import java.util.Stack;

public class task5 {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        String seq = "{[()()]}";
        for (char c : seq.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.peek() != '(') {
                        return;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.empty() || stack.peek() != '[') {
                        return;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.empty() || stack.peek() != '{') {
                        return;
                    }
                    stack.pop();
                    break;
            }
        }
        System.out.println("good");
    }
}
