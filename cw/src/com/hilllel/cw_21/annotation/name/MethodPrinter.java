package com.hilllel.cw_21.annotation.name;

import java.lang.reflect.Method;

public class MethodPrinter {

    public static void invokeAnnotatedMethods(Object obj) throws Exception {
        // Get the class of the passed object
        Class<?> clazz = obj.getClass();

        // Loop through all methods in the class
        for (Method method : clazz.getDeclaredMethods()) {
            // Check if the method is annotated with @PrintMethodName
            if (method.isAnnotationPresent(PrintMethodName.class)) {
                // Print the name of the method
                System.out.println("Method name: " + method.getName());
                // Invoke the method
                method.setAccessible(true);  // In case the method is private
                method.invoke(obj);
            }
        }
    }
}
