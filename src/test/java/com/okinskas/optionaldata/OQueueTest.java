package com.okinskas.optionaldata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OQueueTest {

    OQueue<Integer> queue;

    @BeforeEach
    public void init() {
        queue = new OQueue<>();
    }

    @Test
    public void shouldMakeEmptyOStackAndPeek() {
        assertFalse(queue.peek().isPresent());
    }

    @Test
    public void shouldMakeEmptyOStackAndPop() {
        assertFalse(queue.remove().isPresent());
    }

    @Test
    public void shouldPushAndPeek() {
        queue.add(2);
        assertTrue(queue.peek().isPresent()
                && queue.peek().get() == 2);
    }

    @Test
    public void shouldPushAndPop() {
        queue.add(3);
        queue.remove().ifPresent(i ->
                assertEquals(i, Integer.valueOf(3))
        );
    }

    @Test
    public void shouldLoop() {
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for (Optional<Integer> i = queue.remove(); i.isPresent(); i = queue.remove()) {
            // do nothing
        }

        assertFalse(queue.remove().isPresent());
    }
}
