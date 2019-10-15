package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushToStackSizeIncreasesByOne() {
        Stack stack = new Stack();
        int startSize = stack.count();

        stack.push("Text");

        assertEquals(startSize + 1, stack.count());
    }

    @Test
    void newListIsEmpty() {
        Stack stack = new Stack();

        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Pop from Stack returns last inserted object")
    void popFromStackReturnsLastAddedObject() {
        Stack stack = new Stack();
        stack.push("First");
        stack.push("LIFO");
        assertEquals("LIFO", stack.pop());
    }

    @Test
    void popFromEmptyStackThrowsEmptyStackException() {
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }
}
