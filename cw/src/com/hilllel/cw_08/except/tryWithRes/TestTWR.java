package com.hilllel.cw_08.except.tryWithRes;

import java.io.Closeable;
import java.io.IOException;

public class TestTWR implements Closeable {
//public class TestTWR  {

    void print(){
        System.out.println("try bock...");
    }

    @Override
    public void close() throws IOException {
        System.out.println("TestTWR close");
    }
}
