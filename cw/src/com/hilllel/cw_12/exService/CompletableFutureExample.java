package com.hilllel.cw_12.exService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 1. Асинхронна задача з результатом
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Hello";
        }, executor);

        // 2. Обробка результату (thenApply)
        CompletableFuture<String> upperCaseFuture = future.thenApply(result -> result.toUpperCase());

        // 3. Додавання ще одного кроку (thenCompose)
        CompletableFuture<String> composed = upperCaseFuture.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return s + " world";
        }));

        // 4. Комбінування з іншим майбутнім (thenCombine)
        CompletableFuture<String> another = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "!!!";
        });

        CompletableFuture<String> combined = composed.thenCombine(another, (a, b) -> a + b);

        // 5. Обробка виключень (exceptionally)
        CompletableFuture<String> withExceptionHandling = combined.exceptionally(ex -> "Щось пішло не так: " + ex.getMessage());

        // 6. Дія без повернення результату (thenAccept)
        withExceptionHandling.thenAccept(result -> System.out.println("Фінальний результат: " + result));

        // 7. Завершення при досягненні обох (allOf)
        CompletableFuture<Void> all = CompletableFuture.allOf(future, another);
        all.thenRun(() -> System.out.println("Усі задачі завершено."));

        // 8. Завершення при першому з них (anyOf)
        CompletableFuture<Object> any = CompletableFuture.anyOf(future, another);
        any.thenAccept(first -> System.out.println("Першим завершився: " + first));

        // 9. Блокування до завершення
        combined.get(); // Чекаємо завершення, щоб main не завершився раніше

        executor.shutdown();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
