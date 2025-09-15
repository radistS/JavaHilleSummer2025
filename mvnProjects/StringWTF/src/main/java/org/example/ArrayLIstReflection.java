package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * testing ArrayList with reflection
 *
 *
 * @author  Oleksandr Stepurko
 * @version 0.0.3
 * @since 11.09.2025
 *
 *
 */
public class ArrayLIstReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

       ArrayList alo = new ArrayList(10);
       System.out.println(alo);

        System.out.println("------");
        Class al = alo.getClass();
        Field size = al.getDeclaredField("size");
        size.setAccessible(true);
        size.set(alo, 4);
//        size.setAccessible(false);
//        size.set(alo, 12);
        System.out.println(alo);
        alo.add(12);
        System.out.println(alo);

        Field ed = al.getDeclaredField("elementData");
        ed.setAccessible(true);
        Object[] strArr = (Object[]) ed.get(alo);

        for (Object s : strArr) {
            System.out.print(s + " ");
        }

        size.setAccessible(true);
        size.set(alo, 10);

//        System.out.println(alo);

        System.out.println(alo.get(4));
        System.out.println(alo);

    }
}
