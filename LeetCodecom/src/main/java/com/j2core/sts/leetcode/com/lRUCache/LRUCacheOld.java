package com.j2core.sts.leetcode.com.lRUCache;

import java.util.*;

class LRUCacheOld {

    private int capacity    =   0;
    private int currCap     =   0;
    private Stack<Integer> stack = null;
    private Map<Integer,Integer> map = null;

    public LRUCacheOld(int capacity) {
        this.capacity   =   capacity;
        this.stack      =   new Stack<>();
        this.map        =   new HashMap<>();
    }

    public int get(int key) {

        if(this.map.containsKey(key)){
            stack.remove(Integer.valueOf(key));
            stack.push(key);
        }
        return this.map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            stack.remove(Integer.valueOf(key));
            stack.push(key);
        }else {
            if(currCap == capacity){
                int lastVal =   stack.firstElement();
                map.remove(lastVal);
                stack.remove(Integer.valueOf(lastVal));
            }else{
                currCap++;
            }
            stack.add(key);
        }
        map.put(key,value);
    }
}
