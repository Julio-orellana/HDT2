package uvg.hdt2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(20);
        assertEquals(20, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        stack.push(30);
        assertEquals(30, stack.peek());
        assertFalse(stack.isEmpty());  // peek() no debe eliminar el elemento
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(40);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        stack.push(50);
        stack.push(60);
        assertEquals(2, stack.size());
    }
}
