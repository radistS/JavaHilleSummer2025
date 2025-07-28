package com.hilllel.cw_10;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();

        map.put("K_1", "V_1");
        map.put("K_2", "V_1");
        map.put("K_3", "V_1");
        map.put("K_4", "V_1");
        map.put("K_5", "V_1");
        map.put("K_6", "V_1");
        map.put("K_7", "V_1");
        map.put("K_8", "V_1");
        map.put("K_9", "V_1");

        Set<Entry<String, String>> entries = map.entrySet();
        for (Entry<String, String> e : entries){
            System.out.println("K : " + e.getKey() + ", V : " + e.getValue() );
        }

    }

}
