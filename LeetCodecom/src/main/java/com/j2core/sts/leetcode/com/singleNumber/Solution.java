package com.j2core.sts.leetcode.com.singleNumber;

import java.util.Arrays;

/*
   The class find element witch is single onto number's array
 */
public class Solution {

    /**
     * The method find single element onto array
     *
     * @param nums      number's array
     * @return          single element
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++){

            if (singleNum == nums[i]){
                i++;
                if (i < nums.length) {
                    singleNum = nums[i];
                }
            }
        }
        return singleNum;
    }
}
