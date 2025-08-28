package com.stream.example.ex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class Ex3Test {

    @Test
    void wordCounting() {
        String text = "Hello, world! Hello Java. Java-streams, JAVA?";

        Ex3 ex3 = new Ex3();

        Map<String, Long> result = ex3.wordCounting(text);

        System.out.println();
    }
}
