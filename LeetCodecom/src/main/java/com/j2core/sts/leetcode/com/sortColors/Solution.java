package com.j2core.sts.leetcode.com.sortColors;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public void sortColors(int[] nums) {

        int[] tmp = Arrays.copyOf(nums, nums.length);

        int whiteIndex = 0;
        int blueIndex = nums.length-1;
        nums[whiteIndex] = 1;
        nums[blueIndex] = 1;

        for (int num : tmp){

            if (num == 0){
                nums[whiteIndex++] = 0;
                if (whiteIndex < blueIndex){
                    nums[whiteIndex] = 1;
                }
            }else if (num == 2){
                nums[blueIndex--] = 2;
                if (whiteIndex < blueIndex){
                    nums[blueIndex] = 1;
                }
            }
        }

        if (whiteIndex < blueIndex){
            while (whiteIndex < blueIndex){
                nums[whiteIndex++] = 1;
            }
        }
    }
}
