package com.hilllel.cw_04;

public class Clazz {
    static private int index = 15; //
    private static final Integer DESTINATION_1 = 145; // constanta
    int value; //

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        Clazz.index = index;
    }

    public Clazz() {
    }

    public Clazz(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int calc(){
        return index + value;
    }


}
