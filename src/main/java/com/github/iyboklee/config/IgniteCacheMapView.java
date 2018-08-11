package com.github.iyboklee.config;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.ignite.IgniteCache;

public class IgniteCacheMapView<K, V> implements Map<K, V> {

    private final IgniteCache<K, V> cache;

    public IgniteCacheMapView(IgniteCache<K, V> cache) {
        this.cache = cache;
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean isEmpty() {
        return cache.size() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        return cache.containsKey((K) key);
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        return cache.get((K) key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V put(Object key, Object value) {
        return cache.getAndPut((K) key, (V) value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        return cache.getAndRemove((K) key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(cache::put);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

}