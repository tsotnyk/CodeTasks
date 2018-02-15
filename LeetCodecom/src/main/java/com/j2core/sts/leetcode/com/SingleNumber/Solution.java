package com.j2core.sts.leetcode.com.SingleNumber;

import java.util.Arrays;

public class Solution {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++){

            if (singleNum == nums[i]){
                i++;
                if (i < nums.length) {
                    singleNum = nums[i];
                }
            }
        }
        return singleNum;
    }
}
