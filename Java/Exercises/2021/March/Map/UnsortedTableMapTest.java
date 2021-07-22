package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UnsortedTableMapTest {

    private UnsortedTableMap<String, Integer> tableMap1;
    private UnsortedTableMap<Integer, String> tableMap2;

    private void addToMap() {
        tableMap1.put("Hello", 12);
        tableMap1.put("Google", 14);
        tableMap1.put("Android", 65);
        tableMap1.put("Java", 2);

        tableMap2.put(2016, "Hello");
        tableMap2.put(2017, "Google");
        tableMap2.put(2021, "Android");
    }

    @BeforeEach
    void setUp() {
        tableMap1 = new UnsortedTableMap<>();
        tableMap2 = new UnsortedTableMap<>();
    }

    @Test
    void get() {
        addToMap();
        assertEquals(12, tableMap1.get("Hello"));
        assertEquals("Android", tableMap2.get(2021));
    }

    @Test
    void put() {
        assertTrue(tableMap1.isEmpty());
        assertTrue(tableMap2.isEmpty());
        addToMap();
        assertEquals(4, tableMap1.size());
        assertEquals(3, tableMap2.size());
        assertFalse(tableMap1.isEmpty());
        assertFalse(tableMap2.isEmpty());
    }

    @Test
    void remove() {
        addToMap();
        tableMap1.remove("Google");
        tableMap2.remove(2016);

        assertEquals(3, tableMap1.size());
        assertEquals(2, tableMap2.size());
    }

}