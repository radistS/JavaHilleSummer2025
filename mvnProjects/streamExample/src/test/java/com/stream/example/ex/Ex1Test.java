package com.stream.example.ex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Ex1Test {
    @Test
    public void test1() {
        List<String> input = List.of("Stream", "java", "Level", "mid", "MICROservice", "");
        List<String> output = List.of("java", "level","stream", "microservice");

        Ex1 ex1 = new Ex1();
        assertEquals(output, ex1.ex1(input));
    }
}
