package com.hilllel.cw_05.clone;

public class CloneRun {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest c1 = new CloneTest(12);
        CloneTest c2 = c1.clone();

        System.out.println("c1 ->>>");
        System.out.println(c1);
        System.out.println(c1.pet);
        System.out.println("c2 ->>>");
        System.out.println(c2);
        System.out.println(c2.pet);
    }
}
