import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDoublyIntegerLinkedListTest {
    private MySinglyIntegerLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new MySinglyIntegerLinkedList();
    }

    @Test
    @Order(1)
    public void testSetUp() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    @Order(2)
    public void testAdd() {
        list.addLast(9);
        assertEquals(1, list.getSize());
        list.addFirst(1);
        assertEquals(2, list.getSize());
        list.add(10);
        assertEquals(3, list.getSize());
        list.add(2, 1);
        assertEquals(4, list.getSize());
    }

    @Test
    @Order(3)
    public void testGet() {
        list.addLast(9);
        list.addFirst(1);
        list.add(10);
        list.add(2, 1);

        // List format until now: [1, 2, 9, 10].

        assertEquals(1, list.get(0));
        assertEquals(9, list.getNode(2).getElement());
        assertEquals(1, list.getFirst());
        assertEquals(10, list.getLast());
        int[] temp = list.getAll();
        assertEquals(temp[2], 9);
    }

    @Test
    @Order(4)
    public void testContains() {
        list.add(10);
        assertTrue(list.contains(10));
        assertFalse(list.contains(23));
    }

    @Test
    @Order(5)
    public void testRemove() {
        list.addLast(9);
        list.addFirst(1);
        list.add(10);
        list.add(2, 1);

        // List format until now: [1, 2, 9, 10].

        list.removeFirst();
        assertFalse(list.contains(1));
        assertTrue(list.contains(2));
        list.removeLast();
        assertFalse(list.contains(10));
        list.remove(1);
        assertFalse(list.contains(9));
    }
}
