package com.hilllel.cw_07.task;

/*
Сжатий рядок (Compression)
String compress(String input);
compress("aaabccdddda") → "a3bc2d4a"
Якщо символ зустрічається один раз — не додавати цифру.
 */
public class Compression {

    public static void main(String[] args) {
        System.out.println(compress("aaabccdddda"));
        System.out.println("aaabccdddda");
        System.out.println(decompressChatGPT(compress("aaabccdddda")));
    }

    public static String compress(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        char ch = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (ch == curr) {
                count++;
            } else {
                sb.append(ch);
                if (count > 1) {
                    sb.append(count);
                }
                ch = curr;
                count = 1;
            }
        }

        sb.append(ch);
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

    public static String decompress(String input) {
        char prev = input.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            Integer repeat = 0;
            try {
                repeat = Integer.parseInt(String.valueOf(curr));
            } catch (NumberFormatException ex) {
            }
            String str = String.valueOf(prev).repeat(repeat);
            sb.append(str);
            prev = curr;
            i++;

        }
return sb.toString();
    }


    public static String decompressChatGPT(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            int j = i + 1;
            StringBuilder num = new StringBuilder();
            while (j < input.length() && Character.isDigit(input.charAt(j))) {
                num.append(input.charAt(j));
                j++;
            }
            int count = num.length() > 0 ? Integer.parseInt(num.toString()) : 1;
            sb.append(String.valueOf(ch).repeat(count));
            i = j;
        }
        return sb.toString();
    }
}
