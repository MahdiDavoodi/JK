package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PriorityQueueTest {
    private PriorityQueue<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new PriorityQueue<>();
    }

    @Test
    public void insertTest() {
        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());
        queue.insert(1, "Hello");
        queue.insert(5, "Java");
        queue.insert(5, "Android");
        queue.insert(10, "Kotlin");
        queue.insert(8, "Google");
        assertEquals(5, queue.getSize());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void removeMinTest() {
        queue.insert(1, "Hello");
        queue.insert(5, "Java");
        queue.insert(5, "Android");
        queue.insert(10, "Kotlin");
        queue.insert(8, "Google");
        assertEquals(5, queue.getSize());
        assertEquals(queue.removeMin(), "Hello");
        assertEquals(4, queue.getSize());
        assertEquals(queue.min(), "Java");
    }
}
