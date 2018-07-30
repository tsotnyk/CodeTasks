package com.j2core.sts.leetcode.com.arrays.minimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class Solution {

    public int minMoves2(int[] nums) {

        if (nums.length < 1) return 0;

        Arrays.sort(nums);
        int result = 0;

            int med = nums.length/2;
            int medNum = nums[med];

            for (int num : nums) {

                result = result + Math.abs(num - medNum);
            }


        return result;
    }

}
