package com.hilllel.cw_21.ex;

class Base {
    private int data;

    public Base() {
        this.data = 5;
    }

    public int getData() {
        return data;
    }
}

class Ex3 extends Base {
    private int data;

    public Ex3() {
        super();
        System.out.println(data);
        data = 6;
        System.out.println(data);
    }

    public int getData() {
        return data;
    }

    public static void main(String[] args) {
        Ex3 myData = new Ex3();
        System.out.println(myData.getData());
        System.out.println(myData.data);
    }
}
