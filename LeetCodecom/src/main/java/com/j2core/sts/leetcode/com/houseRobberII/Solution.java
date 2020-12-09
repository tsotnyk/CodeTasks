package com.j2core.sts.leetcode.com.houseRobberII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int rob(int[] nums) {

        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(maxValue(nums, 0, nums.length-1), maxValue(nums, 1, nums.length));
    }

    private int maxValue(int[] nums, int indexStart, int indexEnd){

        int[] matrix = new int[nums.length];
        int index = 0;
        matrix[index++] = 0;
        matrix[index++] = nums[indexStart++];
        while (index < matrix.length){
            matrix[index] = Math.max(matrix[index-1], matrix[index-2]+nums[indexStart++]);
            index++;
        }

        return matrix[nums.length-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(rob(new int[]{4,1,2}), 4);
        Assert.assertEquals(rob(new int[]{2,3,2}), 3);
        Assert.assertEquals(rob(new int[]{1,2,3,1}), 4);
        Assert.assertEquals(rob(new int[]{1,2,1,1}), 3);
        Assert.assertEquals(rob(new int[]{2,3,2,2,1}), 5);
        Assert.assertEquals(rob(new int[]{0}), 0);
    }
}
