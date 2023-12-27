package com.j2core.sts.leetcode.com.max.maxConsecutiveOnes;

public class Solution1 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxLength = 0;
        int length = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                length++;
                continue;
            }

            maxLength = Math.max(maxLength, length);
            length = 0;
        }

        return Math.max(maxLength, length);
    }

}
