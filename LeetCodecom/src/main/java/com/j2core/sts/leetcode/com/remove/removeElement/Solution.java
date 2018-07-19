package com.j2core.sts.leetcode.com.remove.removeElement;

public class Solution {

    public static int removeElement(int[] nums, int val) {

        if (nums.length > 1) {

            int index = -1;

            for (int i = nums.length - 1; i > -1; i--) {

                if (nums[i] != val) {

                    for (int j = index + 1; j < nums.length; j++) {

                        if (nums[j] == val) {
                            index = j;
                            break;
                        }
                    }

                    if (index == -1){

                        return nums.length;
                    }

                    if (index > i) {

                        break;
                    }

                    nums[index] = nums[i];
                    nums[i] = val;

                }
            }
            if (index == -1){
                nums = new int[0];
                index = nums.length;
            }
            return index;

        }else if (nums.length == 0){

            return nums.length;

        }else {

            if (nums[0] == val){
                nums = new int[0];
                return nums.length;
            }else {
                return nums.length;
            }
        }
    }

}
