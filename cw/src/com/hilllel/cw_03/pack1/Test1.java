package com.hilllel.cw_03.pack1;

public class Test1 {

    public Test1() {
        printPrivate();
    }

    private void printPrivate(){
        System.out.println("Private");
    }

    protected void printProtected(){
        System.out.println("Protected");
    }

    void print(){
        System.out.println("Default");
    }

    public void printPublic(){

        System.out.println("Public");
        printPrivate();
    }

}
