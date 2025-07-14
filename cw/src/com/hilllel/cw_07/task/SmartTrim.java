package com.hilllel.cw_07.task;

/*
Безпечне обрізання рядка
**Завдання:**
String smartTrim(String input, int maxLength);
Обрізати рядок до `maxLength`, не обриваючи слова. Додати "..." у кінець, якщо є обрізання. Приклад:
smartTrim("Java is great", 7) → "Java is..."

 */

public class SmartTrim {
    public static void main(String[] args) {
        System.out.println(smartTrim("Java is great", 7));
        System.out.println(smartTrim("Java isnt great", 7));
        System.out.println(smartTrim("", 7));

    }

    private static String smartTrim(String str, int maxLength) {
        if (str == null || str.length() <= 0) {
            return "...";
        }

        if (str.length() < maxLength) {
            return str;
        }

        String tmp = str.substring(0, maxLength + 1);
        int lastSpace = tmp.lastIndexOf(' ') ;
        if (lastSpace > 0){
            tmp = tmp.substring(0, lastSpace);
        }

        return tmp.concat("...");
    }

}
