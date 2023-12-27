package com.j2core.sts.leetcode.com.concatenationOfArray;

public class Solution {

    public int[] getConcatenation(int[] nums) {

        int[] result = new int[nums.length*2];
        int index = 0;
        for (int i = 0; i < result.length; i++){
            if (index == nums.length) index = 0;
            result[i] = nums[index++];
        }

        return result;
    }
}
