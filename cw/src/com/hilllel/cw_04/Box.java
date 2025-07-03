package com.hilllel.cw_04;

public class Box {
    int h = 5;
    int w = 5;
    int d = 5;

    public Box() {
    }

    public Box(int h, int w, int d) {
        System.out.println(this.h);
        this.h = h;
        System.out.println(this.h);
        System.out.println("-----");
        System.out.println(this.w);
        this.w = w;
        System.out.println(this.w);
        System.out.println("---------");
        System.out.println(this.d);
        this.d = d;
        System.out.println(this.d);
    }

    public int getVolume(){
        return h * w * d;
    }
}

class CreateBox {
    public static void main(String[] args) {
        System.out.println(new Box().getVolume());
        System.out.println(new Box(10, 10, 10).getVolume());
    }
}
