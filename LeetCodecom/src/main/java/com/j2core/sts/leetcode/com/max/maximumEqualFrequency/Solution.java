package com.j2core.sts.leetcode.com.max.maximumEqualFrequency;

import java.util.*;

public class Solution {

    public int maxEqualFreq(int[] nums) {

        int result = 0;
        int[] counts = new int[100000+1];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (counts[nums[i]] > 0) {
                int tmp = treeMap.get(counts[nums[i]]);
                if (tmp == 1)
                    treeMap.remove(counts[nums[i]]);
                else
                    treeMap.put(counts[nums[i]], tmp-1);
            }
            counts[nums[i]]++;

            treeMap.put(counts[nums[i]], treeMap.getOrDefault(counts[nums[i]], 0)+1);

            if (treeMap.size() == 1 && (treeMap.firstEntry().getKey() == 1 || treeMap.firstEntry().getValue() == 1) ||
                    treeMap.size() == 2 && (treeMap.firstEntry().getKey() == 1 && treeMap.firstEntry().getValue() == 1) ||
                    (treeMap.lastEntry().getKey() == treeMap.firstKey() +1 && treeMap.lastEntry().getValue() == 1))
                result = i+1;
        }
        return result;
    }
}
