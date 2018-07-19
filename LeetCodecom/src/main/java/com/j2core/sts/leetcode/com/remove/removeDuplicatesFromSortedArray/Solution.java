package com.j2core.sts.leetcode.com.remove.removeDuplicatesFromSortedArray;

public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) return nums.length;

        int index = 0;
        int num = nums[index];
        for (int i = 1; i < nums.length; i++){

            if (num < nums[i]){
                index++;
                if (index != i){
                    nums[index] = nums[i];
                    num = nums[i];

                }else {
                    num = nums[index];
                }
            }

        }

        return index+1;
    }
}
