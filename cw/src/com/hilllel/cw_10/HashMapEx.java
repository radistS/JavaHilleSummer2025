package com.hilllel.cw_10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16, 0.75f); // 12

        map.put(null, "V_1");
        map.put("K_1", "V_1");
        map.put("K_2", "V_1");
        map.put("K_3", "V_1");
        map.put("K_4", "V_1");
        map.put("K_5", "V_1");
        map.put("K_6", "V_1");
        map.put("K_7", "V_1");
        map.put("K_8", "V_1");
        map.put("K_9", "V_1");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> e : entries){
            System.out.println("K : " + e.getKey() + ", V : " + e.getValue() );
        }

        System.out.println("________");
        map.put(null, null);
        entries = map.entrySet();
        for (Map.Entry<String, String> e : entries){
            System.out.println("K : " + e.getKey() + ", V : " + e.getValue() );
        }

        map.put("K_10", "V_1");
        map.put("K_11", "V_1");
        map.put("K_12", "V_1");
        map.put("K_13", "V_1");
        map.put("K_14", "V_1");
        map.put("K_15", "V_1");

        System.out.println("-----------");

        for (String key : map.keySet()){
            System.out.println(key + " >> " +map.get(key));
        }
        System.out.println("-----------");

        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
