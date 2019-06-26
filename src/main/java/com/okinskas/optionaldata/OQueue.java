package com.okinskas.optionaldata;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Queue data-structure wrapper with Optional-based interface.
 * @param <E>
 */
public class OQueue<E> {

    private LinkedList<E> queue;

    /**
     * Creates an empty OQueue.
     */
    public OQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds an element to the back of the queue.
     * @param e the item to be added to the back of the queue.
     * @return The {@code item} argument wrapped in an Optional.
     * @throws IllegalArgumentException cannot add null value to the stack
     */
    public boolean add(E e) {
        if (e == null) throw new IllegalArgumentException("Cannot add null value to OQueue.");
        return queue.add(e);
    }

    /**
     * Returns the object at the front of the queue as an Optional without removing it.
     * If the queue is empty, this returns an empty Optional.
     * @return  The object at the front of the queue an an Optional.
     */
    public Optional<E> peek() {
        return Optional.ofNullable(queue.peek());
    }

    /**
     * Removes the object from the front of the queue and returns it
     * as an Optional. If the stack is empty, this returns
     * and an empty Optional.
     * @return  The object at the top of the stack as an Optional; empty Optional
     *          in the case of the queue being empty.
     */
    public Optional<E> remove() {
        if (queue.isEmpty()) return Optional.empty();
        return Optional.of(queue.remove());
    }
}
