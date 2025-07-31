package com.hilllel.cw_12.exService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableSuccessExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Успішна обробка
            return "Результат обчислення";
        });

        CompletableFuture<String> rusult = future
            .thenApply(result -> "Отримано: " + result) // return
            .exceptionally(ex -> {
                System.out.println("Помилка: " + ex.getMessage());
                return null; // null
            });// Виведе: Отримано: Результат обчислення;

        System.out.println(rusult.get());
    }
}
