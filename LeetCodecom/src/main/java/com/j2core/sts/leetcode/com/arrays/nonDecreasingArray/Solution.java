package com.j2core.sts.leetcode.com.arrays.nonDecreasingArray;

public class Solution {

    public boolean checkPossibility(int[] nums) {

        if (nums.length < 2) return true;

        for (int i = 0; i < nums.length; i++){

            for (int j = 0; j < nums.length; j++){

                if (j == nums.length -1){

                    return true;
                }else {
                    if (j != i) {
                        int num;
                        if (j + 1 == i ) {
                            if (j+1 >= nums.length - 1){
                                return true;
                            }
                            num = nums[j + 2];
                        } else {
                            num = nums[j + 1];
                        }
                        if (nums[j] > num) {
                            break;
                        }
                    }
                }
            }

        }

        return false;

    }
}
