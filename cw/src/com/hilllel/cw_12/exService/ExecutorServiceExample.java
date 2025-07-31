package com.hilllel.cw_12.exService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // 🔹 Створюємо пул потоків з 3 потоками
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 🔹 Відправляємо 5 задач у пул потоків
        for (int i = 1; i <= 5; i++) {
            int taskId = i; // створюємо копію i для використання в лямбді
            executor.submit(() -> { // надсилаємо задачу у виконання
                // 🔸 Виводимо, що задача стартувала і на якому потоці вона працює
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000); // 🔸 Імітуємо виконання задачі (1 секунда)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 🔸 Коректно обробляємо переривання потоку
                }

                // 🔸 Виводимо повідомлення про завершення задачі
                System.out.println("Task " + taskId + " finished");
            });
        }

        // 🔹 Після відправлення всіх задач, зупиняємо прийом нових задач
        executor.shutdown();

        try {
            // 🔹 Чекаємо максимум 10 секунд, поки завершаться всі задачі
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                // 🔸 Якщо задачі не завершились — насильно зупиняємо всі активні потоки
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 🔸 Якщо потік main був перерваний під час очікування — також зупиняємо все
            executor.shutdownNow();
        }
    }

}
