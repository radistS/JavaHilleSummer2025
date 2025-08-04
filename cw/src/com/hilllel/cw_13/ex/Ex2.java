package com.hilllel.cw_13.ex;

import lombok.SneakyThrows;

public class Ex2 extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Ex2());
        Thread t2 = new Thread(new Ex2());
        Thread t3 = new Thread(new Ex2());
//        t1.run();
//        t2.run();
//        t3.run();

        t1.start();
        t2.start();
        t3.start();
    }

    @SneakyThrows
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            sleep(1111);
        }
    }
}
