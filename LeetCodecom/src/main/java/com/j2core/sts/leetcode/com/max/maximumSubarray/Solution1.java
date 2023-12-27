package com.j2core.sts.leetcode.com.max.maximumSubarray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = max;

        for (int i = 1; i < nums.length; i++){
            if (sum < 0){
                sum = 0;
            }
            sum += nums[i];

            max = Math.max(max, sum);
        }

        return max;
    }

    @Test
    public void test(){


        Assert.assertEquals(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
        Assert.assertEquals(maxSubArray(new int[]{-2,-1}), -1);
    }
}
