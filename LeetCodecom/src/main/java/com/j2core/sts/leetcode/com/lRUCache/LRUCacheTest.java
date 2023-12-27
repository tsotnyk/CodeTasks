package com.j2core.sts.leetcode.com.lRUCache;

import org.testng.annotations.Test;

public class LRUCacheTest {

    @Test
    public void test() {

        LRUCacheOld cache = new LRUCacheOld(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));

        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        LRUCacheOld cache1 = new LRUCacheOld(2);

        System.out.println(cache1.get(2));
        cache1.put(2, 6);
        System.out.println(cache1.get(1));

        cache1.put(1, 5);
        cache1.put(1,2);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(2));

//        LRUCache cache2 = new LRUCache(2);
//
//        System.out.println(cache2.get(2));
//        cache2.put(2, 6);
//        System.out.println(cache2.get(1));
//
//        cache2.put(1, 5);
//        cache2.put(1,2);
//        System.out.println(cache2.get(1));
//        System.out.println(cache2.get(2));
    }
}
