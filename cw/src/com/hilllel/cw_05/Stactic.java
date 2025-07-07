package com.hilllel.cw_05;

public class Stactic {
    static String sName = "test";

    private String name;

    public Stactic(String name) {
        this.name = name;
    }
     public void print(){
         System.out.println(sName + " " + name);
     }
}

class Run{
    public static void main(String[] args) {
        Stactic s1 = new Stactic("1");
        Stactic s2 = new Stactic("2");


        s1.print();
        s2.print();

    }
}
