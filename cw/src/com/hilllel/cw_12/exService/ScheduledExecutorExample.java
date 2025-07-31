package com.hilllel.cw_12.exService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Запуск задачи: " + System.currentTimeMillis());

        // Запуск каждые 2 секунды, начиная через 1 секунду
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Если нужно запустить один раз через 3 секунды:
        // scheduler.schedule(task, 3, TimeUnit.SECONDS);
    }
}
