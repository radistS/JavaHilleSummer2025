package com.stream.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilterStreamTest {

    private FilterStream filterStream;

    @BeforeEach
    void setUpBeforeClass() {
        filterStream = new FilterStream();
    }

    @Test
    void allMaxTen() {
        List<Integer> in = List.of(1, 2, 3, 4, 5, 6, 10, 8, 9, 11);
        List<Integer> out = filterStream.allMaxTen(in);
        assertEquals(1, out.size());
        assertEquals(List.of(11), out);

    }

    @Test
    void filterString(){
        List<String> in = List.of("Java", "Scala", "JavaScript", "javaEE");
        List<String> out = filterStream.filterString(in);
        assertEquals(3, out.size());
    }

    @Test
    void allOdd(){
        List<Integer> in = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> out = filterStream.allOdd(in);
        assertFalse(out.isEmpty());
        assertEquals(3, out.size());
        assertEquals(List.of(2, 4, 6), out);
    }

    @Test
    void stringLengthMoreThanFive(){
        List<String> in = List.of("Java", "Scala", "JavaScript", "javaEE");
        List<String> out = filterStream.stringLengthMoreThanFive(in);
        assertEquals(2, out.size());
    }

    @Test
    void stringFindAllStartWithA(){
        List<String> in = List.of("Aa", "aA", "ss", " a", "    a");
        List<String> out = filterStream.stringFindAllStartWithA(in);
        assertEquals(4, out.size());
    }

    @Test
    void maxAverage(){

        // create collection
        Random random = new Random();
        IntStream randomInts = random.ints(2_000_000);
        List<Integer> in = randomInts.limit(300_000).boxed().toList();

        long start = System.nanoTime();
        filterStream.filterByAverage(in);
        long end = System.nanoTime();
        System.out.println(convertNanosecondsToMinutesSecondsMillis(end - start));

        System.out.println();

        start = System.nanoTime();
        filterStream.filterIntByAverage(in);
        end = System.nanoTime();
        System.out.println(convertNanosecondsToMinutesSecondsMillis(end - start));

    }

    // Method to convert nanoseconds to mm:ss format
    public static String convertNanosecondsToMinutesSecondsMillis(long nanoseconds) {
        // Convert nanoseconds to total seconds
        long totalSeconds = nanoseconds / 1_000_000_000;

        // Convert the remainder to milliseconds
        long milliseconds = (nanoseconds / 1_000_000) % 1_000;

        // Convert total seconds to minutes
        long minutes = totalSeconds / 60;

        // Remaining seconds after converting to minutes
        long remainingSeconds = totalSeconds % 60;

        // Return the result in mm:ss.SSS format
        return String.format("%02d:%02d.%03d", minutes, remainingSeconds, milliseconds);
    }
}
