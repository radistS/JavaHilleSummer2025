package com.stream.example.ex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Ex2Test {

    @Test
    public void groupByFirstLetter() {
        List<String> names = List.of("Alice","adam","Bob", "Bab", "brian","АЛЛА");
        Ex2 ex = new Ex2();
        Map<String, List<String>> stringListMap = ex.groupByFirstLetter(names);

        System.out.println();

    }
}
