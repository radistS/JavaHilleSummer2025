package com.hilllel.cw_04.box;


public class Box {
    private int h;      // --> 0
    private int w;      // --> 0
    private int d;      // --> 0


    public Box(int h, int w, int d) {
        setH(h);
        this.w = w;
        this.d = d;
    }

    public Box() {
    }

    public void setH(int h) {
        this.h = h;
    }
    public void setW(int w) {
        this.w = w;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Box{" +
            "h=" + h +
            ", w=" + w +
            ", d=" + d +
            '}';
    }


}
