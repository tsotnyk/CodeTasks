package com.j2core.sts.leetcode.com.MissingNumber;

import java.util.Arrays;

/*
   The class find the one number witch missing from the array
 */
public class Solution {

    /**
     * The method find the one number witch missing from the array
     *
     * @param nums    array with numbers
     * @return        number witch missing from the array
     */
    public int missingNumber(int[] nums) {
        int result;
        if (nums.length == 1){
            int tmp = nums[0];
            if (tmp == 0) {
                result = 1;
            }else if (tmp == 1){
                result = 0;
            }else result = tmp+1;
        }else {
            Arrays.sort(nums);
            int num = nums[0];
            if (num > 0) return 0;
            for (int i = 1; i < nums.length; i++) {
                int tmpNum = nums[i];
                num = num + 1;
                if (num != tmpNum) {
                    return num;
                }
            }
            result = num + 1;
        }
        return result;
    }
}
