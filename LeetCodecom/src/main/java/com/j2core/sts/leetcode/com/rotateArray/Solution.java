package com.j2core.sts.leetcode.com.rotateArray;

public class Solution {

    public void rotate(int[] nums, int k) {

        if(nums.length > k) {

            int lastIndex = nums.length - k;

            int[] tmp = new int[k];

            for (int i = 0; i < k; i++) {

                tmp[i] = nums[lastIndex + i];

            }

            System.arraycopy(nums, 0, nums, k, nums.length - k);

            for (int i = 0; i < k; i++) {

                nums[i] = tmp[i];

            }
        }else if (nums.length != k){

            int step = 0;
            while (step < k){

                int tmp = nums[nums.length-1];

                for (int i = nums.length-1; i > 0; i--){

                    nums[i] = nums[i-1];

                }
                nums[0] = tmp;
                step++;

            }
        }

    }
}
