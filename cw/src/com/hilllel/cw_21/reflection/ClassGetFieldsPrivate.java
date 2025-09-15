package com.hilllel.cw_21.reflection;

import java.lang.reflect.Field;

public class ClassGetFieldsPrivate {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Faza faza = new Faza("email@email.com", 5554433L);

        System.out.println(faza);

        Field f = faza.getClass().getDeclaredField("id"); // private
        f.setAccessible(true); // open private field
        f.set(faza, 2);
        System.out.println(f.get(faza));

        System.out.println(faza);

        f = faza.getClass().getDeclaredField("email"); // private
        f.setAccessible(true);
        f.set(faza, "new_email@email.com");

        System.out.println(faza);

        f = faza.getClass().getDeclaredField("phone"); // private
        f.setAccessible(true);
        f.set(faza, 9998877L);

        System.out.println(faza);

        f = faza.getClass().getDeclaredField("st"); // private static
        f.setAccessible(true);
        f.set(faza, "aaaaa");

        f = faza.getClass().getDeclaredField("isActive"); // public
        f.set(faza, true);

        System.out.println(faza);

        System.out.println(new Faza("aa.com", 1111L));
    }
}

class Faza {
    private final Integer id = 1;
    private final String email;
    private static String st =  "st";
    private final Long phone;
    public boolean isActive;

    public Faza(String email, Long phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Faza{" +
                "id = " + id +
                ", email ='" + email + '\'' +
                ", phone = " + phone +
                ", st = " + st +
                ", isActive = " + isActive +
                '}';
    }
}
