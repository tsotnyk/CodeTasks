package com.j2core.sts.leetcode.com.houseRobber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int rob(int[] nums) {

        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length < 3) return Math.max(nums[0], nums[1]);

        int[] matrix = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                matrix[i] = nums[i];
            }else if (i == 1){
                matrix[i] = Math.max(matrix[i-1], nums[i]);
            }else {
                matrix[i] = Math.max(matrix[i-1], nums[i]+matrix[i-2]);
            }
        }

        return matrix[nums.length-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(rob(new int[]{1,2,3,1}), 4);
        Assert.assertEquals(rob(new int[]{2,1,1,2}), 4);

    }
}
