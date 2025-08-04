package com.hillel.tests.collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class CollectionTest {

    @Test
    void add() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add("a"));
        assertEquals(1, collection.size());
        assertEquals("a", collection.get(0));
        assertTrue(collection.contain("a"));
    }

    @Test
    void testAdd() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add(0,"a"));
        assertEquals(1, collection.size());
        assertEquals("a", collection.get(0));
        assertTrue(collection.contain("a"));
    }

    @Test
    void testAdd_invalid_index_less_zero() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertFalse(col.add(-1, str));
        assertEquals(0, col.size());
    }

    @Test
    void testAdd_invalid_index_more_than_size() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertFalse(col.add(1, str));
        assertEquals(0, col.size());
    }

    @Test
    void delete() {
        // given
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add("a"));
        assertEquals(1, collection.size());
        // when
        assertTrue(collection.delete("a"));
        // then
        assertFalse(collection.contain("a"));

    }
//
//    @Test
//    void get() {
//    }
//

    @Test
    void contain() {
        Collection collection = new Collection();

    }
//
//    @Test
//    void testEquals() {
//    }
//
//    @Test
//    void clear() {
//    }
//
//    @Test
//    void size() {
//    }
}
