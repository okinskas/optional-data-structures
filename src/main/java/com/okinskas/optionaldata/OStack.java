package com.okinskas.optionaldata;

import java.util.Optional;
import java.util.Stack;

/**
 * Stack data-structure wrapper with Optional-based interface.
 * @param <E>
 */
public class OStack<E> {

    private Stack<E> stack;

    /**
     * Creates an empty OStack.
     */
    public OStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes an element to the top of the stack.
     * @param item the item to be pushed onto the stack.
     * @return The {@code item} argument wrapped in an Optional.
     * @throws IllegalArgumentException cannot add null value to the stack
     */
    public Optional<E> push(E item) {
        if (item == null) throw new IllegalArgumentException("Cannot add null value to OStack.");
        return Optional.ofNullable(stack.push(item));
    }

    /**
     * Removes the object from the top of the stack and returns it
     * as an Optional. If the stack is empty, this returns
     * and an empty Optional.
     * @return The object at the top of the stack as an Optional.
     */
    public synchronized Optional<E> pop() {
        if (stack.empty()) return Optional.empty();
        return Optional.of(stack.pop());
    }

    /**
     * Returns the object at the top of the stack as an Optional without removing it.
     * If the stack is empty, this returns an empty Optional.
     * @return The object at the top of the stack an an Optional.
     */
    public synchronized Optional<E> peek() {
        if (stack.empty()) return Optional.empty();
        return Optional.ofNullable(stack.peek());
    }

    /**
     * Returns the position of an object {@code o} on the stack.
     * @param o The desired object.
     * @return  index of the object from the top of the stack (starting at 1); the
     *          return value of -1 indicates it is not on the stack.
     */
    public synchronized int search(Object o) {
        return stack.search(o);
    }
}
