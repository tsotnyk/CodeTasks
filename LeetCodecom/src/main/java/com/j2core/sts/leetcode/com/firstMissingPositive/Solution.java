package com.j2core.sts.leetcode.com.firstMissingPositive;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int firstMissingPositive(int[] nums) {

        int length = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < length; i++){

            if(!numMap.containsKey(nums[i])){
                numMap.put(nums[i], null);
            }

        }

        for (int j = 1; j <= length; j++){

            if (!numMap.containsKey(j)){
                return j;
            }
        }

        return length+1;
    }
}
