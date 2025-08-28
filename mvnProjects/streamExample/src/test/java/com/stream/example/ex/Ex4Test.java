package com.stream.example.ex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class Ex4Test {

    @Test
    void topTen() {
        Map<String, Long> freq = Map.of(
            "jva", 5L,
            "java", 5L,
            "hello", 3L,
            "world", 3L,
            "stream", 2L,
            "code", 1L
        );

        Ex4 ex4 = new Ex4();
        System.out.println(ex4.topTen(freq));
    }
}
