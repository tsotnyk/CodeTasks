package com.j2core.sts.leetcode.com.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public boolean containsDuplicateOld(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ){

            int num = nums[i];
            int counter = 1;

            while (++i < nums.length && nums[i] == num){
                counter++;
            }

            if (counter > 1) return true;
        }
        return false;
    }

    public boolean containsDuplicateSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            if (set.contains(num)){
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicateSort(int[] nums) {

        if (nums == null || nums.length < 1) return false;
        Arrays.sort(nums);
        int index = 1;
        int num = nums[0];

        while (index < nums.length){
            if (nums[index] == num){
                return true;
            }else {
                num = nums[index++];
            }
        }

        return false;
    }
}
