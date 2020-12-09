package com.j2core.sts.leetcode.com.arrays.combinationSumIV;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int combinationSum4(int[] nums, int target) {

        int[] array = new int[target+1];

        for (int i = 1; i < array.length; i++){

            for (int j = nums.length-1; j > -1; j--){
                int delta = i-nums[j];
                if (delta == 0){
                    array[i] += 1;
                }else if (delta > 0){
                    array[i] += array[i-nums[j]];
                }
            }
        }

        return array[target];
    }

    @Test
    public void test(){

        Assert.assertEquals(combinationSum4(new int[]{1,2,3}, 4), 7);
    }
}
