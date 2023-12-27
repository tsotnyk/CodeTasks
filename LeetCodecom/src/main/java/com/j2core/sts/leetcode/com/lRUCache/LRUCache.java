package com.j2core.sts.leetcode.com.lRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    HashMap<Integer, CacheNode> map;
    CacheNode head;
    int capacity;
    int size;

    public LRUCache(int capacity) {

        this.map = new HashMap<>();
        this.head = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {

        CacheNode node = this.map.get(key);

        if (node == null) return -1;

        node.prev.next = node.next;


        return node.value;
    }

    public void put(int key, int value) {

    }
}

class CacheNode{

    int key;
    int value;
    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.key = key;
    }
}
