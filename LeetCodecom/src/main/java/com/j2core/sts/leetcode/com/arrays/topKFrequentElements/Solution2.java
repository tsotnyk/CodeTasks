package com.j2core.sts.leetcode.com.arrays.topKFrequentElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] list = new List[nums.length+1];

        for (int key : map.keySet()){
            int index = map.get(key);
            if (list[index] == null){
                list[index] = new LinkedList<>();
            }
            list[index].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = list.length-1; i >= 0; i--){
            if (index == k) break;
            if (list[i] == null) continue;
            while (index < k && !list[i].isEmpty()){
                res[index++] = list[i].remove(0);
            }
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(topKFrequent(new int[]{1,1,1,2,2,3}, 2), new int[]{1,2});
    }
}
