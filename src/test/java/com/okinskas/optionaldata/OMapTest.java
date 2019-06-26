package com.okinskas.optionaldata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class OMapTest {

    private OMap<Integer, Integer> map;

    @BeforeEach
    public void init() {
        map = new OMap<>();
    }

    @Test
    public void shouldMakeEmptyOMap() {
        assertTrue(map.keySet().isEmpty());
    }

    @Test
    public void shouldReturnEmptyOptionalOnBadLookup() {
        assertFalse(map.get(0).isPresent());
    }

    @Test
    public void shouldReturnNonEmptyOptionalOnGoodLookup() {
        map.put(0, 1);
        assertTrue(map.get(0).isPresent());
    }

    @Test
    public void shouldReturnEmptyOptionalAfterRemoval() {
        map.put(0, 1);
        map.remove(0);
        assertFalse(map.get(0).isPresent());
    }
}
