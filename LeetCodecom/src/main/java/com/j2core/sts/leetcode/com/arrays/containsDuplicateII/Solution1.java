package com.j2core.sts.leetcode.com.arrays.containsDuplicateII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution1 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
