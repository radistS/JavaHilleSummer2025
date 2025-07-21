package com.hilllel.cw_09.alCustom;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int count = 1000;

         for (int j = 0; j < 4; j++){
             System.out.println(" -------------- COUNT : " + count +" --------------");
             long start = System.currentTimeMillis();
             Collection cCust = new CollectionImpl();
             for (int i = 0 ; i < count; i++){
                 if(i % (count/10) == 0) System.out.print("#");
                 cCust.add(String.valueOf(i));
             }
             System.out.printf("   >>>>> Custom collection : add >> %s, duration :  %s ms%n", count, (System.currentTimeMillis() - start));

             start = System.currentTimeMillis();
             Collection myCol = new MyCollectionImpl();
             for (int i = 0 ; i < count; i++){
                 if(i % (count/10) == 0) System.out.print("#");
                 myCol.add(String.valueOf(i));
             }
             System.out.printf("   >>>>> myCollection : add >> %s, duration :  %s ms%n", count, (System.currentTimeMillis() - start));

             start = System.currentTimeMillis();
             List list = new ArrayList();
             for (int i = 0 ; i < count; i++){
                 if(i % (count/10) == 0) System.out.print("#");
                 list.add(String.valueOf(i));
             }

             System.out.printf("   >>>>> List (java) collection : add >> %s, duration :  %s ms%n", count, (System.currentTimeMillis() - start));
             System.out.println("------------------------");
             count = count * 10;
         }





    }
}
