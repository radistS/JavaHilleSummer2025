package com.hilllel.cw_04;

import java.lang.reflect.InvocationTargetException;

public class ExampleRun {
    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Example e1 = new Example(12);
        Example e2 = new Example(13);
        Example e3 = e1;

        System.out.println(e1); // default .toString()
        System.out.println(e2.toString());
        System.out.println(e3);

        e1.a = 25;
        System.out.println("----------");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e3 = e2);
        System.out.println(e3 );

        e3.a = 100;

        System.out.println(e2);

        System.out.println(e2 == e3);

    }
}
