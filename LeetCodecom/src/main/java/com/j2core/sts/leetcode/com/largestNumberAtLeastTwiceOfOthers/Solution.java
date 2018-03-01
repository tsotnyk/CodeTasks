package com.j2core.sts.leetcode.com.largestNumberAtLeastTwiceOfOthers;

/*
   The class find whether the largest element in the array is at least twice as much as every other number in the array.
 */
public class Solution {

    /**
     * The method find index the largest element in the array is at least twice as much as every other number in the array
     *
     * @param nums  array with numbers for check
     * @return      return the index of the largest element, or return -1.
     */
    public int dominantIndex(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }else {
            int index = 0;
            int maxValue = nums[index];
            for (int i = 1; i < nums.length; i++){
                if (maxValue < nums[i]){
                    maxValue = nums[i];
                    index = i;
                }
            }

            for (int j = 0; j < nums.length;  j++){

                if (nums[j] != maxValue){
                    if (nums[j]*2 > maxValue) {
                        return -1;
                    }
                }
            }
            return index;
        }
    }
}
