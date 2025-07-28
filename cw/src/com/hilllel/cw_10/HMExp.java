package com.hilllel.cw_10;

import java.util.HashMap;
import java.util.Map;

public class HMExp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < Integer.MAX_VALUE; i++){
//        for (int i = 0; i < 60_000_000; i++){
            if (i % 10_000_000 == 0) System.out.print("#");
//            System.out.println(i);
            map.put(i,i);
        }
    }
}
