package com.hilllel.cw_10.countChar;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public static void main(String[] args) {
        String text = Text.getText();
        String[] split = text.toLowerCase().split("");
        Map<String, Integer> chars = new HashMap<>();
        for (String str : split) {

            chars.put(str, chars.getOrDefault(str, 0) + 1);


//            if (chars.containsKey(str)) {
//                chars.put(str, chars.get(str) + 1);
//            } else {
//                chars.put(str, 1);
//            }
        }
        System.out.println(chars);

    }

}
