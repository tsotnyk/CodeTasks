package com.j2core.sts.leetcode.com.arrays.maximumSizeSubarraySumEqualsK;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxSubArrayLen(int[] nums, int k) {

        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0] == k ? 1 : 0;

        int maxLength = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if (sum[0] == k) maxLength = 1;

        for (int i = 1; i < nums.length; i++){
            sum[i] = nums[i];
            if (sum[i] == k && maxLength < 1) maxLength = 1;
            for (int j = 0; j < i; j++){
                sum[j] += nums[i];
                if (sum[j] == k){
                    maxLength = Math.max(maxLength, i-j+1);
                }
            }
        }

        return maxLength;
    }

    @Test
    public void test(){
        Assert.assertEquals(maxSubArrayLen(new int[]{-1,1}, -1), 4);

        Assert.assertEquals(maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3), 4);
    }
}
