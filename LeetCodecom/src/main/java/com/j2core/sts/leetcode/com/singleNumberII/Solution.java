package com.j2core.sts.leetcode.com.singleNumberII;

import java.util.Arrays;

public class Solution {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1;){

            if (nums[i] != nums[i+1]){
                return nums[i];
            }else {
                i = i+3;
            }
        }
        return nums[nums.length-1];
    }
}
