package com.hilllel.cw_28;

import java.util.HashMap;
import java.util.Map;

public class HMap {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap();

        map.put("1", "1");
        System.out.println(map.get("1"));

        map.put("1", "2");
        System.out.println(map.get("1")); // replace

        map.replace("1", "3");
        System.out.println(map.get("1"));

        map.put("2", null);
        map.replace("2", "4");
        System.out.println(map.get("2"));
        map.replace("2", "4", "5");
        System.out.println(map.get("2"));
        map.replace("2", "4", "6");
        System.out.println(map.get("2"));

        System.out.println(map.get(null));
        map.put(null, "5");
        System.out.println(map.get(null));
        map.put(null, null);
        System.out.println(map.get(null));
    }

}
