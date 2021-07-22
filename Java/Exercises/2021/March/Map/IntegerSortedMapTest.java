package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSortedMapTest {
    private IntegerSortedMap<String> sortedMap;

    private void addToSortedMap() {

        sortedMap.put(12, "Hello ");
        sortedMap.put(15, "my ");
        sortedMap.put(20, "name ");
        sortedMap.put(25, "is ");
        sortedMap.put(30, "Mahdi!");
        sortedMap.put(13, "all, ");
    }

    @BeforeEach
    void setUp() {
        sortedMap = new IntegerSortedMap<>();
    }

    @Test
    void get() {
        addToSortedMap();
        assertEquals("Hello ", sortedMap.get(12));
        assertEquals("Mahdi!", sortedMap.get(30));
    }

    @Test
    void put() {
        assertTrue(sortedMap.isEmpty());
        addToSortedMap();
        assertEquals(6, sortedMap.size());
        assertFalse(sortedMap.isEmpty());
    }

    @Test
    void remove() {
        addToSortedMap();
        assertEquals("Hello ", sortedMap.remove(12));
        assertEquals(5, sortedMap.size());
    }

    @Test
    void Entry() {
        addToSortedMap();
        assertEquals("Hello ", sortedMap.firstEntry().getValue());
        assertEquals("Mahdi!", sortedMap.lastEntry().getValue());
        assertEquals("my ", sortedMap.floorEntry(17).getValue());
        assertEquals("name ", sortedMap.ceilingEntry(17).getValue());
        assertEquals("Mahdi!", sortedMap.lastEntry().getValue());
        assertEquals("is ", sortedMap.lowerEntry(30).getValue());
        assertEquals("my ", sortedMap.higherEntry(13).getValue());
    }

}