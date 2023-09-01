package com.j2core.sts.leetcode.com.sum.twoSum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (cache.containsKey(diff)){
                return new int[]{cache.get(diff), i};
            }
            cache.put(nums[i], i);
        }

        return new int[]{};
    }

    @Test
    public void test(){

        Assert.assertEquals(twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
    }
}
