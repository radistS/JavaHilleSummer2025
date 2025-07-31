package com.hilllel.cw_12;

public class InterruptExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Працюю...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // Потік перерваний під час сну — тут можна завершити роботу
                System.out.println("Потік був перерваний під час сну");
            }
            System.out.println("Завершення роботи потоку");
        });

        worker.start();

        // Чекаємо 3 секунди, потім перериваємо потік
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Надсилаємо сигнал переривання...");
        worker.interrupt();
    }
}
