package com.j2core.sts.leetcode.com.subarraySumsDivisibleByK;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0, count = 0;
        Map <Integer, Integer> map = new HashMap<>() ;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int tmp = sum % k;
            int key = (tmp + k) % k;
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    @Test
    public void test(){

        Assert.assertEquals(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5), 7);
    }
}
