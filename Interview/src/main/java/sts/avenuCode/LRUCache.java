package sts.avenuCode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    LinkedList<Integer> list;
    HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {

        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        this.list.remove(Integer.valueOf(key));
        this.list.add(key);
        return this.map.getOrDefault(key, -1);

    }

    public void put(int key, int value) {

        if (this.map.size() < capacity){
            this.map.put(key, value);
        }else {
            int removeKey = this.list.removeFirst();
            while (!this.map.containsKey(removeKey)){
                removeKey = this.list.removeFirst();
            }
            this.map.remove(removeKey);
            this.map.put(key, value);
        }
        this.list.add(key);
    }
}
