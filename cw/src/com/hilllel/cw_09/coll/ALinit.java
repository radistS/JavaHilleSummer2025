package com.hilllel.cw_09.coll;

import java.util.ArrayList;

public class ALinit {
    public static void main(String[] args) {
        ArrayList<String> arrS = new ArrayList<>(15); // 10
        ArrayList<String> arrSt = new ArrayList<>(2_000); // 10


        System.out.println(arrS.size()); //-> 0
//        arrS.set(4, null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(4, null);
        System.out.println(arrS.size()); //-> 5


    }
}
