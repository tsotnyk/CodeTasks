package com.j2core.sts.leetcode.com.containsDuplicateIII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k == 0 || nums.length < 2 || t < 0) return false;

        for (int i = 0; i < nums.length-1; i++){

            for (int j = i+1; j <= i+k; j++){

                if (j == nums.length) break;

                if(Math.abs(nums[i]-nums[j])<=t && Math.abs((long)nums[i]-(long)nums[j]) <=Integer.MAX_VALUE) return true;
            }
        }

        return false;
    }


    @Test
    public void test(){

        boolean result = containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0);

        Assert.assertTrue(result);

        boolean result1 = containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2);

        Assert.assertTrue(result1);

        boolean result2 = containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);

        Assert.assertFalse(result2);

        boolean result3 = containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4);

        Assert.assertFalse(result3);

        boolean result4 = containsNearbyAlmostDuplicate(new int[]{-2147483647, 2147483647}, 1, 2147483647);

        Assert.assertFalse(result4);
    }
}
