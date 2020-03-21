package com.j2core.sts.leetcode.com.sum.twoSumIII_DataStructureDesign;

import java.util.*;

public class TwoSum {

    private Map<Integer, List<Integer>> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        List<Integer> lst = map.getOrDefault(number, new LinkedList<>());
        lst.add(number);
        map.put(number, lst);    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            int num = entry.getKey();
            if (value == 0 && map.size() == 1 && map.containsKey(0))
                return map.get(0).size() > 1;
            int comp = value - num;
            if (comp == num && comp != value && map.containsKey(comp)) {
                return map.get(comp).size() > 1;
            }
            if (map.containsKey(comp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
}
