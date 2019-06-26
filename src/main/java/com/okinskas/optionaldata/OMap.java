package com.okinskas.optionaldata;

import java.util.*;

public class OMap<K, V> {

    Map<K, V> map;

    public OMap() {
        map = new HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Optional<V> get(Object key) {
        return Optional.ofNullable(map.get(key));
    }

    public Optional<V> put(K key, V value) {
        return Optional.ofNullable(map.put(key, value));
    }

    public Optional<V> remove(Object key) {
        return Optional.ofNullable(map.remove(key));
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    public void clear() {
        map.clear();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public Collection<V> values() {
        return map.values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
