package com.j2core.sts.leetcode.com.arrays.findPivotIndex;

public class Solution {

    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return -1;
        }

        int baseSum = 0;
        int sum = 0;

        for(int num : nums) {
            baseSum = baseSum + num;
        }

        for(int i=0;i<nums.length;i++){

            baseSum = baseSum - nums[i];

            if(baseSum == sum)
                return i;

            sum = sum + nums[i];
        }

        return -1;
    }

}
