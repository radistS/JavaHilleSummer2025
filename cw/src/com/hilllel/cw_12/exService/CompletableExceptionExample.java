package com.hilllel.cw_12.exService;

import java.util.concurrent.CompletableFuture;

public class CompletableExceptionExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Симуляція помилки
            throw new RuntimeException("Щось пішло не так");
        });

        future
            .thenApply(result -> "Отримано: " + result)
            .exceptionally(ex -> {
                System.out.println("Помилка: " + ex.getMessage());
                return "Значення за замовчуванням";})
            .thenAccept(System.out::println);  // Виведе: Значення за замовчуванням
    }
}
