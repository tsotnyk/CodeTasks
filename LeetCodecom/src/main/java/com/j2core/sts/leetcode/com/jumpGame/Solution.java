package com.j2core.sts.leetcode.com.jumpGame;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean canJumpOld(int[] nums) {

        if (nums.length < 2) return true;

        int counter = 1;

        for (int i = nums.length-2; i > 0; i--){
            if (nums[i] >= counter){
                counter = 1;
            }else {
                counter++;
            }
        }

        return nums[0] >= counter;
    }

    public boolean canJump(int[] nums) {

        if (nums.length < 2) return true;

        int index = nums.length-2;
        int steps = 1;

        while (index > 0){
            if (nums[index--] >= steps){
                steps = 1;
            }else {
                steps++;
            }
        }

        return nums[index] >= steps;
    }

    @Test
    public void test(){

        Assert.assertFalse(canJump(new int[]{0,2,3}));
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
        Assert.assertTrue(canJump(new int[]{2,3,1,1,4}));


    }
}
