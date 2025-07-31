package com.hilllel.cw_12;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.err.println("    Потік почав роботу...");
            try {
                Thread.sleep(2000); // імітація довгої роботи
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("    Потік завершив роботу.");
        });

        worker.start(); // запускаємо потік

        System.out.println("Головний потік чекає завершення дочірнього потоку...");

        try {
            worker.join(); // головний потік чекає завершення worker
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Головний потік завершив роботу.");
    }

}
