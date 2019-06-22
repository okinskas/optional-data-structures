package com.okinskas.optionaldata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OStackTest {

    OStack<Integer> stack;

    @BeforeEach
    public void init() {
        stack = new OStack<>();
    }

    @Test
    public void shouldMakeEmptyOStackAndPeek() {
        assertFalse(stack.peek().isPresent());
    }

    @Test
    public void shouldMakeEmptyOStackAndPop() {
        assertFalse(stack.pop().isPresent());
    }

    @Test
    public void shouldPushAndPeek() {
        stack.push(2);
        assertTrue(stack.peek().isPresent()
                && stack.peek().get() == 2);
    }

    @Test
    public void shouldPushAndPop() {
        stack.push(3);
        stack.pop().ifPresent(i ->
                assertEquals(i, Integer.valueOf(3))
        );
    }

    @Test
    public void shouldLoop() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Optional<Integer> i = stack.pop(); i.isPresent(); i = stack.pop()) {
            // do nothing
        }

        assertFalse(stack.pop().isPresent());
    }

    @Test
    public void shouldSearch() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(stack.search(1), 3);
    }
}
