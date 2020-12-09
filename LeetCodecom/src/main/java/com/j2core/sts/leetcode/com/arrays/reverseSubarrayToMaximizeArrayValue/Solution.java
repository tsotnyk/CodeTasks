package com.j2core.sts.leetcode.com.arrays.reverseSubarrayToMaximizeArrayValue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxValueAfterReverse(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.abs(nums[0]-nums[1]);

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length-1; ){
            for (int j = nums.length-1; j <= i; j--){

            }
        }
        return 0;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxValueAfterReverse(new int[]{2,3,1,5,4}), 10);
        Assert.assertEquals(maxValueAfterReverse(new int[]{2,4,9,24,2,1,10}), 68);

    }
}
