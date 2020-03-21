package com.j2core.sts.leetcode.com.arrays.findMinimumInRotatedSortedArray;

public class Solution {

    public int findMin(int[] nums) {

        int first = 0;
        int last = nums.length-1;
        if (nums[first] < nums[last]) return nums[first];

        while (first < last){

            if (nums[first] > nums[first+1]) return nums[first+1];

            if (nums[last] < nums[last-1]) return nums[last];

            first++;
            last--;
        }

        return nums[first];
    }
}
