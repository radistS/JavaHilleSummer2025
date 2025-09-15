package com.hilllel.cw_21.reflection;

import java.lang.reflect.Field;

public class ClassGetFieldsInt {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.hillel.lesson_22.reflection.FeeInt");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("Field name : " + field.getName());
            System.out.println("Field type : " + fld.getName());

        }
    }
}

interface FeeInt{
    static public String email = null;
    static public Long phone = 0L;
}
