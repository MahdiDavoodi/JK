package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWorksWithLinkedListTest {
    private QueueWorksWithLinkedList<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueWorksWithLinkedList<>();
    }

    @Test
    public void testSize() {
        assertTrue(queue.isEmpty());
        queue.enqueue("A");
        assertEquals(1, queue.size());
        queue.enqueue("B");
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeue() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
        assertTrue("A".equals(queue.dequeue()));
        assertEquals(1, queue.size());
    }

    @Test
    public void testFirst() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        assertTrue("A".equals(queue.first()));
    }
}