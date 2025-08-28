package com.stream.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapStreamTest {

    private MapStream mapStream;

    @BeforeEach
    void setUpBeforeClass() {
        mapStream = new MapStream();
    }

    @Test
    void mapStringToLength() {
        List<String> in = List.of("Java", "Scala", "JavaScript", "javaEE");
        List<Integer> out = mapStream.mapStringToLength(in);
        assertEquals(4, out.size());
        assertEquals(List.of(4, 5, 10, 6), out);

    }

    @Test
    void uniqueChars() {
        List<String> in = List.of("aaa", "aabb", "abcabc", "abcd", "", "aA");
        assertEquals(List.of("a","ab", "abc", "abcd", "", "Aa"), mapStream.uniqueChar(in));

    }

    @Test
    public void testUniqueCharWithDuplicates() {
        List<String> input = Arrays.asList("hello", "world", "java");
        List<String> expected = Arrays.asList("ehlo", "dlorw", "ajv");
        assertEquals(expected, mapStream.uniqueChar(input));
    }

    @Test
    public void testUniqueCharWithSingleChars() {
        List<String> input = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected, mapStream.uniqueChar(input));
    }

    @Test
    public void testUniqueCharWithEmptyStrings() {
        List<String> input = Arrays.asList("", "");
        List<String> expected = Arrays.asList("", "");
        assertEquals(expected, mapStream.uniqueChar(input));
    }

    @Test
    public void testUniqueCharWithSpecialCharacters() {
        List<String> input = Arrays.asList("123", "!@#", "abc!");
        List<String> expected = Arrays.asList("123", "!#@", "!abc");
        assertEquals(expected, mapStream.uniqueChar(input));    }

    @Test
    public void testUniqueCharWithMixedCase() {
        List<String> input = Arrays.asList("aAbB", "aAAa", "BbBb");
        List<String> expected = Arrays.asList("ABab", "Aa", "Bb");
        assertEquals(expected, mapStream.uniqueChar(input));
    }

    @Test
    public void testUniqueCharWithNullInput() {
        List<String> input = null;
        assertThrows(NullPointerException.class, () ->mapStream.uniqueChar(input));
    }

    @Test
    public void updateObjectPeek() {
        assertEquals("alex@mail.com",
            mapStream.updatePersonInformationPeek(List.of(new Person("alex", 40))).get(0).getEmail());
    }

    @Test
    public void updateObjectMap() {
        assertEquals("alex@mail.com",
            mapStream.updatePersonInformationMap(List.of(new Person("alex", 40))).get(0).getEmail());
    }
}
