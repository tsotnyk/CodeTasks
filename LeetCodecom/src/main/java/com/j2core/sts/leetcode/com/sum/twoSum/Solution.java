package com.j2core.sts.leetcode.com.sum.twoSum;

import java.util.HashMap;

/*
   The class return indices of the two numbers such that they add up to a specific target
 */
public class Solution {

    /**
     * The method return indices of the two numbers such that they add up to a specific target
     *
     * @param nums       array with numbers
     * @param target     target sum
     * @return           indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSumOld(int[] nums, int target) {
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

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int secondNum = target - nums[i];
            if (map.containsKey(secondNum)){
                return new int[]{map.get(secondNum), i};
            }else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
