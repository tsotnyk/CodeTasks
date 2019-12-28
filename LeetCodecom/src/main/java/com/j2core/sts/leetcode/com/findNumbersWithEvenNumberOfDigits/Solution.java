package com.j2core.sts.leetcode.com.findNumbersWithEvenNumberOfDigits;

public class Solution {

    public int findNumbers(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++){

            String num = String.valueOf(nums[i]);
            if (num.length()%2 == 0){
                result++;
            }
        }

        return result;
    }
}
