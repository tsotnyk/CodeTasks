package com.j2core.sts.leetcode.com.arrays.singleElementInSortedArray;

public class Solution1 {

    public int singleNonDuplicate(int[] nums) {

        int i = 1;
        while (i < nums.length){
            if (nums[i] != nums[i-1]) return nums[i-1];
            i += 2;
        }

        return nums[i-1];
    }
}
