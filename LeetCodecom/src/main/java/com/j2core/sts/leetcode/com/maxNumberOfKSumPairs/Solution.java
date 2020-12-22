package com.j2core.sts.leetcode.com.maxNumberOfKSumPairs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> numberMap = new HashMap<>();
        int counter = 0;

        for (int num : nums){
            numberMap.put(num, numberMap.getOrDefault(num, 0)+1);
        }

        for (int num : nums){
            int pair = k-num;
            int delta = num == pair ? 2 : 1;
            if (numberMap.get(num) >= delta && numberMap.containsKey(pair) && numberMap.get(pair) >= delta){
                counter++;
                numberMap.put(num, numberMap.get(num)-1);
                numberMap.put(pair, numberMap.get(pair)-1);
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxOperations(new int[]{1,2,3,4}, 5), 2);
        Assert.assertEquals(maxOperations(new int[]{3,1,3,4,3},6),1);
    }
}
