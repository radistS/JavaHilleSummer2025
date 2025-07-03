package com.hilllel.cw_04.fin;

public class FinalEx implements IntfFinal{

    void print(){
        System.out.println("print...");
    }

    final void print2(){
        System.out.println("print2 final ...");
    }

    @Override
    public void print(String str) {
        System.out.println("print " + str);
    }
}
