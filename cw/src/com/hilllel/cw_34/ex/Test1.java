package com.hilllel.cw_34.ex;

public class Test1 {
    public static void main(String[] args) {
        Test1 test = new Test1();
//        System.out.println(test == this);
    }
}

class Test{
    void method(){
        System.out.println(this);
    }

    void method1(){
        this.method();
    }
}
