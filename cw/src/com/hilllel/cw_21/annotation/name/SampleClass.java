package com.hilllel.cw_21.annotation.name;

public class SampleClass {

    @PrintMethodName
    public void sampleMethod1() {
        System.out.println("Executing sampleMethod1");
    }

    @PrintMethodName
    public void sampleMethod2() {
        System.out.println("Executing sampleMethod2");
    }

    public void nonAnnotatedMethod() {
        System.out.println("This method is not annotated");
    }

}
