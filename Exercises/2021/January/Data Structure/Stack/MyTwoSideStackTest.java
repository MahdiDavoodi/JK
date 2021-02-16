package ir.blog.mahdidavoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTwoSideStackTest {
    private MyTwoSideStack<String> myTwoSideStack;

    @BeforeEach
    public void setUp() {
        myTwoSideStack = new MyTwoSideStack<>(27);
    }

    @Test
    public void testSize() {
        assertTrue(myTwoSideStack.isEmpty());
        myTwoSideStack.push("A");
        myTwoSideStack.pushB("Z");
        assertEquals(2, myTwoSideStack.size());
        myTwoSideStack.push("B");
        assertEquals(3, myTwoSideStack.size());
    }

    @Test
    public void testPop() {
        myTwoSideStack.push("A");
        myTwoSideStack.pushB("Z");
        myTwoSideStack.push("B");
        assertEquals(3, myTwoSideStack.size());
        assertTrue("Z".equals(myTwoSideStack.popB()));
        assertEquals(2, myTwoSideStack.size());
        assertTrue("B".equals(myTwoSideStack.pop()));
        assertEquals(1, myTwoSideStack.size());
    }

    @Test
    public void testTop() {
        myTwoSideStack.push("A");
        myTwoSideStack.push("B");
        myTwoSideStack.push("C");
        myTwoSideStack.push("D");
        myTwoSideStack.pushB("W");
        myTwoSideStack.pushB("X");
        myTwoSideStack.pushB("Y");
        myTwoSideStack.pushB("Z");
        assertTrue("Z".equals(myTwoSideStack.topB()));
        assertTrue("D".equals(myTwoSideStack.top()));
    }

    @Test
    public void testBottom() {
        myTwoSideStack.push("A");
        myTwoSideStack.push("B");
        myTwoSideStack.push("C");
        myTwoSideStack.push("D");
        myTwoSideStack.pushB("W");
        myTwoSideStack.pushB("X");
        myTwoSideStack.pushB("Y");
        myTwoSideStack.pushB("Z");
        assertTrue("W".equals(myTwoSideStack.bottomB()));
        assertTrue("A".equals(myTwoSideStack.bottom()));
    }
}
