package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainHashMapTest {

    private ChainHashMap<Integer, String> hashMap;

    private void addToHashMap() {

        hashMap.put(325, "Hello");
        hashMap.put(678, "Google");
        hashMap.put(234, "Android");
    }

    @BeforeEach
    void setUp() {
        hashMap = new ChainHashMap<>(20);
    }

    @Test
    void get() {
        addToHashMap();
        assertEquals("Hello", hashMap.get(325));
        assertEquals("Android", hashMap.get(234));
    }

    @Test
    void put() {
        assertTrue(hashMap.isEmpty());
        assertTrue(hashMap.isEmpty());
        addToHashMap();
        assertEquals(3, hashMap.size());
        assertFalse(hashMap.isEmpty());
    }

    @Test
    void remove() {
        addToHashMap();
        hashMap.remove(234);
        assertEquals(2, hashMap.size());
    }
}