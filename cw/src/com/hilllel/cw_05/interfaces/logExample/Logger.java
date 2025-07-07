package com.hilllel.cw_05.interfaces.logExample;

public interface Logger {

    void printLog(String msg);

    String xxx();

    default void print() {
        System.out.println("print from interface");
    }
}
