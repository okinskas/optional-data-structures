package com.okinskas.optionaldata;

import java.util.LinkedList;
import java.util.Optional;

public class OQueue<E> {

    private LinkedList<E> queue;

    public OQueue() {
        queue = new LinkedList<>();
    }

    public boolean add(E e) {
        return queue.add(e);
    }

    public Optional<E> peek() {
        return Optional.ofNullable(queue.peek());
    }

    public Optional<E> remove() {
        if (queue.isEmpty()) return Optional.empty();
        return Optional.ofNullable(queue.remove());
    }
}
