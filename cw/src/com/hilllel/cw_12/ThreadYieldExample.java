package com.hilllel.cw_12;

public class ThreadYieldExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " — крок " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield(); // Підказка планувальнику: можна передати процесор іншим потокам
            }
        };

        Thread t1 = new Thread(task, "🔵 Потік 1");
        Thread t2 = new Thread(task, "🟢 Потік 2");

        t1.start();
        t2.start();
    }
}
