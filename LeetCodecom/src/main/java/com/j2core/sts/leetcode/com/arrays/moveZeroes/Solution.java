package com.j2core.sts.leetcode.com.arrays.moveZeroes;

public class Solution {

    public void moveZeroes(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++){

            if (nums[i] == 0){

                for (int j = i+1; j< length; j++){

                    if (nums[j] != 0){

                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;

                    }
                }
            }
        }
    }
}
