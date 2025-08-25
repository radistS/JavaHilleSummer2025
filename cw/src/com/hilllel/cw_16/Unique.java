package com.hilllel.cw_16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Unique {

    public static void main(String[] args) {
        List<String> lst = List.of("1", "2", "3", "2", "3", "4", "5");

        Uni uni = new Uni();

        ArrayList arr1 = uni.getUnique1(lst);
        ArrayList arr2 = uni.getUnique2(lst);


        System.out.println(arr1);
        System.out.println(arr1.size());
        System.out.println(arr2);
        System.out.println(arr2.size());
    }
}

class Uni{

    public ArrayList getUnique1(List lst){
        return new ArrayList(new HashSet(lst));
    }

    public ArrayList getUnique2(List lst){
        ArrayList arr = new ArrayList();
        arr.add(new HashSet<>(lst));
        return arr;
    }
}
