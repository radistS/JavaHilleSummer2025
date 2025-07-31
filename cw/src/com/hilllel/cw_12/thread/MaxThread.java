package com.hilllel.cw_12.thread;

public class MaxThread {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        int i = 0;
        while (true){

            Thread th = new Thread(r);
            th.start();
            System.out.println(i++);
        }
    }
}
