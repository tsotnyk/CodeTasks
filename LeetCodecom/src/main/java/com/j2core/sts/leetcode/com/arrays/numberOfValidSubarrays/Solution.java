package com.j2core.sts.leetcode.com.arrays.numberOfValidSubarrays;

import org.testng.annotations.Test;

public class Solution {

    public int validSubArrays(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++){
            result++;
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] >= nums[i]){
                    result++;
                }else break;
            }
        }
        return result;
    }

}
