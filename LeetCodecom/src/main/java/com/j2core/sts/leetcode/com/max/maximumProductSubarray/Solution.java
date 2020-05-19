package com.j2core.sts.leetcode.com.max.maximumProductSubarray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProduct(int[] nums) {

        int[] sum = new int[nums.length];

        int max = nums[0];
        sum[0] = max;

        for (int i = 1; i < nums.length; i++){
            sum[i] = nums[i];
            max = Math.max(max, nums[i]);
            for (int j = 0; j < i; j++){
                int tmp = sum[j]*nums[i];
                max = Math.max(tmp, max);
                sum[j] = tmp;
            }
        }

        return max;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxProduct(new int[]{2, -5, -2, -4, 3}), 24);
    }
}
