package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersianStackTest {
    private PersianStack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new PersianStack<>();
    }

    @Test
    public void testSize() {
        assertTrue(stack.ayaKhalist());
        stack.darj("A");
        assertEquals(1, stack.hajm());
        stack.darj("B");
        assertEquals(2, stack.hajm());
    }

    @Test
    public void testPop() {
        stack.darj("A");
        stack.darj("B");
        assertEquals(2, stack.hajm());
        assertTrue("B".equals(stack.bardashtan()));
        assertEquals(1, stack.hajm());
    }

    @Test
    public void testTop() {
        stack.darj("A");
        stack.darj("B");
        stack.darj("C");
        stack.darj("D");
        assertTrue("A".equals(stack.avvalin()));
    }

    @Test
    public void testBottom() {
        stack.darj("A");
        stack.darj("B");
        stack.darj("C");
        stack.darj("D");
        assertTrue("D".equals(stack.akharin()));
    }
}
