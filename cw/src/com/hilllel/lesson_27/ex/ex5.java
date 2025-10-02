package com.hilllel.lesson_27.ex;

class Car {
    void speed(Byte val) {
        System.out.println("DARK");
    }

    void speed(byte... vals) {
        System.out.println("LIGHT");
    }

}

public class ex5 {

    public static void main(String... args) {
//        byte[] b = {10};
        byte b = 10;
        new Car().speed(b);

        new Car().speed((byte) 1, (byte)2, (byte)3);
        new Car().speed();
    }
}
