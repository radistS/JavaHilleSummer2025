package com.hilllel.cw_34.ex;

class MyLink{
    public MyLink(){
        str = "New";
    }
    public String str;
}

public class Test4{
    public static void main(String[] args) {
        MyLink b1 = new MyLink();
        System.out.println(b1.str);
        MyLink b2 = b1;
        b2.str = "MyString";
        System.out.println(b1.str);
        System.out.println(b2.str);

        System.out.println("-----------------------");

        String a1 = "Test";
        String a2 = a1;
        a1 = "Not a Test";
        System.out.println(a1);
        System.out.println(a2);
    }
}
