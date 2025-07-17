package com.hilllel.cw_08.except.tryWithRes;

import java.io.IOException;

public class Run {

    public static void main(String[] args) {
        try(TestTWR testTWR = new TestTWR()){
            testTWR.print();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            System.out.println("run finally");
        }

    }

}
