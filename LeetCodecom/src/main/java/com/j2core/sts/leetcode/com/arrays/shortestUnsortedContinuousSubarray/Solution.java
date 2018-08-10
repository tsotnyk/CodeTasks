package com.j2core.sts.leetcode.com.arrays.shortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {

        int[] copy = nums.clone();

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        while (i < j) {

            if (copy[i] == nums[i] && copy[j] == nums[j]) {
                i++;
                j--;
            } else if (copy[i] != nums[i] && copy[j] != nums[j]) {
                break;
            } else if (copy[i] != nums[i]) {
                j--;
            } else {
                i++;
            }
        }
        return j == i ? 0 : j - i + 1;
    }
}
