package com.j2core.sts.leetcode.com.lRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheNew<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public static void main(String[] args) {
        LRUCacheNew<Integer, Integer> cache = LRUCacheNew.newInstance(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(3, 3);

        System.out.println(cache);
    }

    private LRUCacheNew(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> LRUCacheNew<K, V> newInstance(int size) {
        return new LRUCacheNew<K, V>(size);
    }

}
