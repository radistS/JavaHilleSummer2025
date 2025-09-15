package com.hilllel.cw_21.annotation.time;

public class SampleClass {
    @ExecutionTime
    public void fastMethod() {
        System.out.println("Executing fastMethod");
    }

    @ExecutionTime
    public void slowMethod() throws InterruptedException {
        Thread.sleep(1000); // Симуляция долгой операции
        System.out.println("Executing slowMethod");
    }

    public void nonAnnotatedMethod() {
        System.out.println("This method is not annotated");
    }
}
