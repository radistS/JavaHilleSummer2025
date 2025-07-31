package com.hilllel.cw_12;

public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Початок");

        try {
            // Призупиняємо потік на 2 секунди
            Thread.sleep(2000); // 2000 мс = 2 с
        } catch (InterruptedException e) {
            System.out.println("Потік був перерваний");
        }

        System.out.println("Кінець після 2 секунд");
    }
}
