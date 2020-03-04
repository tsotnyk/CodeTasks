package com.j2core.sts.leetcode.com.max.maximumSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {

        int[] sums = new int[nums.length];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                sums[j] += nums[i];
                if (sums[j] > result) {
                    result = sums[j];
                }
            }
        }
        return result;
    }
    public int maxSubArrayNew(int[] nums) {

        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

}
