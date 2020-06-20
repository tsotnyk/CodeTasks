package com.j2core.sts.leetcode.com.arrays.longestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {

        int[] array = new int[nums.length];

        for (int i = nums.length - 1; i > -1; i--) {
            if (i == nums.length - 1) {
                array[i] = 1;
            } else {
                int index = i + 1;
                int length = 0;
                while (index < nums.length) {
                    if (nums[i] < nums[index]) {
                        length = Math.max(length, array[index]);
                    }
                    index++;
                }
                array[i] = length + 1;
            }
        }

        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxLength < array[i]) {
                maxLength = array[i];
            }
        }
        return maxLength;
    }
}
