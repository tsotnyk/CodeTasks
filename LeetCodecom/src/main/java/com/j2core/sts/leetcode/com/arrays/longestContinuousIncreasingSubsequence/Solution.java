package com.j2core.sts.leetcode.com.arrays.longestContinuousIncreasingSubsequence;

public class Solution {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0){
            return 0;
        }else if (nums.length < 2){
            return 1;
        }else {

            int lengthSubString = 1;
            for (int i = 0; i < nums.length - 1; i++) {

                int tmpLengthSubstring = 1;
                for (int j = i; j < nums.length - 1; j++) {

                    int num1 = nums[j];
                    if (nums[j + 1] <= num1) {
                        break;
                    }
                    tmpLengthSubstring++;
                }
                if (lengthSubString < tmpLengthSubstring) {

                    lengthSubString = tmpLengthSubstring;
                }
            }
            return lengthSubString;
        }
    }
}
