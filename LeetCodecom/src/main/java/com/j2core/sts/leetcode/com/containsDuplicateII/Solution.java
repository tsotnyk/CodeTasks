package com.j2core.sts.leetcode.com.containsDuplicateII;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length > k){

            for (int i = 0; i < nums.length-1; i++){

                if (i < nums.length-k) {

                    for (int j = i + 1; j <= i + k; j++) {

                        if (nums[i] == nums[j]) {

                            return true;
                        }
                    }
                }else {

                    for (int j = i+1; j < nums.length; j++){

                        if (nums[i] == nums[j]) {

                            return true;
                        }
                    }
                }
            }

            return false;

        }else {

            for (int l = 0; l < nums.length-1; l++){

                for (int m = l+1; m < nums.length; m++){

                    if (nums[l] == nums[m]){

                        return true;
                    }
                }
            }

            return false;

        }
    }
}
