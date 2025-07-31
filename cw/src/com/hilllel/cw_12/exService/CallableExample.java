package com.hilllel.cw_12.exService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        // 🔹 Створюємо пул з 1 потоку (single-threaded executor)
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 🔹 Створюємо задачу типу Callable, яка повертає рядок
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName() + " початок роботи ...");
            Thread.sleep(1000); // 🔸 Імітуємо виконання задачі протягом 1 секунди
            return "Привіт з Callable"; // 🔸 Повертаємо результат
        };

        Callable<Integer> task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " початок роботи ...");
            Thread.sleep(1000); // 🔸 Імітуємо виконання задачі протягом 1 секунди
            return 1; // 🔸 Повертаємо результат
        };

        // 🔹 Надсилаємо Callable у пул і отримуємо Future — об'єкт для отримання результату в майбутньому
        Future<String> future = executor.submit(task);

        Future<Integer> future1 = executor.submit(task1);
        // 🔹 Поки задача виконується — можемо робити щось інше
        System.out.println("Виконується інша робота...");

        // 🔹 Очікуємо завершення задачі та отримуємо результат
        // Метод future.get() блокує потік до завершення задачі
        String result = future.get();
        Integer res = future1.get();

        // 🔹 Виводимо результат, який повернув Callable
        System.out.println("Результат: " + result);
        System.out.println("Результат int : " + res);

        // 🔹 Завершуємо роботу ExecutorService
        executor.shutdown();
    }
}
