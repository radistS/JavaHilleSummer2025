package com.stream.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgregateStreamTest {

    private AgregateStream stream;

    @BeforeEach
    void setUpBeforeClass() {
        stream = new AgregateStream();
    }

    @Test
    void countOdd() {
        List<Integer> in = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(3, stream.countOdd(in));
    }

    @Test
    void maxStringLength(){
        String[] strings = {"Apple", "Banana", "Cherry", "Blueberry", "Mango"};

        assertEquals(9, stream.maxStringLength(Arrays.asList(strings)));
        assertEquals(9, stream.maxStringLength1(Arrays.asList(strings)));
    }

    @Test
    void isEmpty(){
        String[] strings = {"Apple", "Banana", "Cherry", "Blueberry", "Mango"};
        String[] strings1 = {"", "Banana", "Cherry", "Blueberry", "Mango"};
        String[] strings2 = {null, "Banana", "Cherry", "Blueberry", "Mango"};

        assertFalse( stream.isEmptyStringExist(Arrays.asList(strings)));
        assertTrue( stream.isEmptyStringExist(Arrays.asList(strings1)));
        assertTrue( stream.isEmptyStringExist(Arrays.asList(strings2)));
        assertTrue( stream.isEmptyStringExistNull(Arrays.asList(strings1)));
        assertFalse(stream.isEmptyStringExistNull(Arrays.asList(strings2)));
    }
}
