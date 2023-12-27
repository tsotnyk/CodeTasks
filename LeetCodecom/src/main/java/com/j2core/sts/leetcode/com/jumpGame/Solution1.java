package com.j2core.sts.leetcode.com.jumpGame;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean canJump(int[] nums) {

        int iE = nums.length-1;
        int i = iE-1;

        while (i >= 0){

            if (i+nums[i] >= iE){
                iE = i;
            }
            i--;
        }

        return iE == 0;
    }

    @Test
    public void test(){

        Assert.assertTrue(canJump(new int[]{2,3,1,1,4}));
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
    }
}
