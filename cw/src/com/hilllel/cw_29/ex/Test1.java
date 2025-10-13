package com.hilllel.cw_29.ex;

public class Test1 implements Runnable {

    @Override
    public void run() {
        System.out.println(3);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Test1());
        thread.start();
        System.out.println(1);
        thread.join();
        System.out.println(2);
    }
}
