package com.j2core.sts.leetcode.com.arrays.maxConsecutiveOnesII;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int zeroIndex = -1;
        boolean zero = false;
        int index = 0;
        int counter = 0;

        while (index < nums.length){
            if (nums[index] == 1){
                counter++;
            }else {
                if (zero){
                    counter = index - zeroIndex;
                    zeroIndex = index;
                }else {
                    counter++;
                    zeroIndex = index;
                    zero = true;
                }
            }
            maxCount = Math.max(maxCount, counter);
            index++;
        }

        return Math.max(maxCount, counter);
    }

    @Test
    public void test(){

        Assert.assertEquals(4, findMaxConsecutiveOnes(new int[]{1,1,0,1}));
        Assert.assertEquals(4, findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
        Assert.assertEquals(4, findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));

    }
}
