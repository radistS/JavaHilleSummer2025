package com.hilllel.cw_21.annotation.time;

import java.lang.reflect.Method;

public class MethodTimer {

    public static void invokeAnnotatedMethods(Object obj) throws Exception {
        // Получаем класс переданного объекта
        Class<?> clazz = obj.getClass();

        // Проходимся по всем методам класса
        for (Method method : clazz.getDeclaredMethods()) {
            // Проверяем, аннотирован ли метод @LogExecutionTime
            if (method.isAnnotationPresent(ExecutionTime.class)) {
                // Замер времени выполнения метода
                long startTime = System.currentTimeMillis();

                // Выполняем метод
                method.setAccessible(true);  // На случай, если метод приватный
                method.invoke(obj);

                // Замеряем время после выполнения метода
                long endTime = System.currentTimeMillis();
                System.out.println(
                    "time " + method.getName() + ": " + (endTime - startTime)
                        + " ms");
            }
        }
    }
}
