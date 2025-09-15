package com.hilllel.cw_21.annotation.name;

public class Run {
    public static void main(String[] args) throws Exception {
        SampleClass obj = new SampleClass();
        MethodPrinter.invokeAnnotatedMethods(obj);
    }

}
