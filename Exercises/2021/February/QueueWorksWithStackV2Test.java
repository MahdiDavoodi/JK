package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWorksWithStackV2Test {
    private QueueWorksWithStackV2<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueWorksWithStackV2<>();
    }

    @Test
    public void enqueueTest() {
        assertEquals(0, queue.size());
        queue.enqueue("Hello");
        assertFalse(queue.isEmpty());
        queue.enqueue("Java");
        queue.enqueue("Google");
        assertEquals(3, queue.size());
    }

    @Test
    public void dequeueTest() {
        queue.enqueue("Hello");
        queue.enqueue("Java");
        queue.enqueue("Google");
        assertEquals(3, queue.size());
        String string = queue.dequeue();
        assertEquals(2, queue.size());
        assertTrue("Hello".equals(string));
        String string2 = queue.dequeue();
        assertEquals(1, queue.size());
        assertTrue("Java".equals(string2));
    }

    @Test
    public void firstTest() {
        queue.enqueue("Java");
        queue.enqueue("Android");
        queue.enqueue("Google");
        assertEquals(3, queue.size());
        String string = queue.first();
        assertEquals(3, queue.size());
        assertTrue("Java".equals(string));
    }
}