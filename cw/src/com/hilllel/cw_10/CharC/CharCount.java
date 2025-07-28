package com.hilllel.cw_10.CharC;

import java.awt.ItemSelectable;
import java.util.HashMap;

public class CharCount {

    public static void main(String[] args) {

        // letter count >> String text
        // normalise text -- to lowercase, remove not letter char
        // print table


        String text = Text.getText();
        text = normalize(text);
        HashMap<Character, Integer> map = count(text);
        for (Object key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    private  static HashMap<Character, Integer> count(String text){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : text.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else{
                map.put(c, 1);
            }
        }

        return map;
    }

    private static String normalize(String text){
        return text.replaceAll("[^A-Za-zА-Яа-яЁё]", "").toLowerCase();
    }

}
