package prepInterviewApple;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    HashMap<Integer, Integer> map;
    int maxSize;
    LinkedList<Integer> list;

    public LRUCache(int capacity) {

        this.map = new HashMap<>();
        this.maxSize = capacity;
        this.list = new LinkedList<>();
    }

    public int get(int key) {

        Integer keyObject = key;
        if (!this.map.containsKey(key)) return -1;
        this.list.remove(keyObject);
        this.list.addFirst(keyObject);

        return this.map.get(key);
    }

    public void put(int key, int value) {

        if (this.map.containsKey(key)){
            this.map.put(key, value);
            Integer keyObject = key;
            this.list.remove(keyObject);
            this.list.addFirst(keyObject);
            return;
        }
        if (this.list.size() == maxSize){
            removeOldValue();
        }
        this.map.put(key, value);
        list.addFirst(key);
    }

    private void removeOldValue(){
        int oldKey = this.list.removeLast();
        this.map.remove(oldKey);
    }
}

class Test{

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

//        cache.put(1,1);
//        cache.put(2,2);
//        int res1 = cache.get(1);
//        cache.put(3,3);
//        int res2 = cache.get(2);
//        cache.put(4,4);
//        int res3 = cache.get(1);
//        int res4 = cache.get(3);
//        int res5 = cache.get(4);
    }



}


