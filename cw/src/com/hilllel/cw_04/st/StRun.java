package com.hilllel.cw_04.st;

public class StRun {

    public static void main(String[] args) {
        Student s1 = new Student();

        int age = 15;
        s1.setFirstName("Oleksandr");
        s1.setLastName("Stepurko");

        if (ValidatorService.ageValidator(age)){
            s1.setAge(age);
        } else {
            System.out.println("age less than 18");
        }

        System.out.println(s1.fullName());

        System.out.println(s1);
    }



}
