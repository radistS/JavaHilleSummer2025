package com.hilllel.cw_24.gof.builder;

import java.util.UUID;

public class BuilderRun {

    public static void main(String[] args) {
        Student st1 = new Student();
        System.out.println(st1);;

        Student st2 = Student.builder()
            .id(UUID.randomUUID())
            .age(18)
            .build();
        System.out.println(st2);

    }

}
