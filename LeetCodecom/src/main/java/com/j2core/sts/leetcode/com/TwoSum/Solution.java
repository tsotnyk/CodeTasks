package com.j2core.sts.leetcode.com.TwoSum;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int index = 0;
        int secondIndex = -1;

        for (int j = index; j < nums.length; j++) {
            int firstNum = nums[j];
            int deltaSecondNum = target - firstNum;

            for (int i = j + 1; i < nums.length; i++) {
                if (i != j) {
                    if (nums[i] == deltaSecondNum) {
                        secondIndex = i;
                        break;
                    }
                }
            }
            if (secondIndex != -1){
                index = j;
                break;
            }
        }
        return new int[]{index, secondIndex};
    }
}
