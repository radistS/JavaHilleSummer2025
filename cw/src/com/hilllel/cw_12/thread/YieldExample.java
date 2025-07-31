package com.hilllel.cw_12.thread;

public class YieldExample {

    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        System.out.println(Thread.currentThread().getName());

        producer.setPriority(1);
        consumer.setPriority(1);

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    public void run() {
        Thread.yield();
        for (int i = 0; i < 10; i++) {
            System.out.print(Thread.currentThread().getName() + " >> ");
//            if (i == 5)  Thread.currentThread().setName("rename thread " + i);
            System.out.println("I am Producer : Produced Item " + i);

        }
    }
}

class Consumer extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}

