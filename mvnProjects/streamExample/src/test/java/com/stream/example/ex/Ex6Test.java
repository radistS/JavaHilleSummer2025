package com.stream.example.ex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Ex6Test {

    @Test
    void bucketsMap() {
        List<Integer> ages = List.of(12, 17, 18, 22, 25, 26, 30, 35, 40, 50, 51, 60);
        Ex6 ex6 = new Ex6();
        System.out.println(ex6.bucketsMap(ages));

    }
}
