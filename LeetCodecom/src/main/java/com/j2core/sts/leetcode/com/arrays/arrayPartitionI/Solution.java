package com.j2core.sts.leetcode.com.arrays.arrayPartitionI;

import java.util.Arrays;

public class Solution {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int result = 0;
        boolean last = false;
        if (nums.length%2 != 0) last = true;

        for (int i = 0; i < nums.length; ){

            result = result + nums[i];
            i = i+2;
        }

        if (last) result = result + nums[nums.length-1];

        return result;
    }
}
