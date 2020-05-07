package com.j2core.sts.leetcode.com.insertDeleteGetRandomO1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {

    ArrayList<Integer> numList;
    HashMap<Integer, Integer> numMap;
    int index;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.numList = new ArrayList<>();
        this.numMap = new HashMap<>();
        this.index = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numMap.containsKey(val)) return false;
        numMap.put(val, index);
        numList.add(index++, val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = numMap.remove(val);
        if (index == null) return false;
        numList.set(index, null);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) (Math.random() * numList.size());
        while (numList.get(index) == null){
            index = (int) (Math.random() * numList.size());
        }

        return numList.get(index);
    }

    @Test
    public static void test(){

        RandomizedSet set = new RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertFalse(set.remove(2));
        Assert.assertTrue(set.insert(2));
        System.out.println(set.getRandom());
        Assert.assertTrue(set.remove(1));
        Assert.assertFalse(set.insert(2));
        System.out.println(set.getRandom());

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


