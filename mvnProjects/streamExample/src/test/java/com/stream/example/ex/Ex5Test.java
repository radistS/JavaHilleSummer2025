package com.stream.example.ex;

import java.util.List;
import org.junit.jupiter.api.Test;

class Ex5Test {

    @Test
    void toFlatMap() {
        List<List<String>> data = List.of(
            List.of("java", "spring", "docker"),
            List.of("kafka", "java", "sql"),
            List.of("spring", "testing")
        );

        Ex5 ex5 = new Ex5();
        List<String> result = ex5.toFlatMap(data);
        System.out.println(result);
    }
}
