package com.j2core.sts.leetcode.com.sum4;

import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();

        if (nums.length < 4){
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length-3; i++){
            for (int j = i+1; j < length-2; j++){
                for (int k = j+1; k < length-1; k++){
                    for (int l = k+1; l < length; l++){

                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target){
                            List<Integer> tmpList = new LinkedList<>();
                            tmpList.add(nums[i]);
                            tmpList.add(nums[j]);
                            tmpList.add(nums[k]);
                            tmpList.add(nums[l]);
                            set.add(tmpList);
                        }
                    }
                }
            }
        }

        return new LinkedList<>(set);
    }
}
