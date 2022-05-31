package com.j2core.sts.leetcode.com.countPairsWithXORInRange;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int countPairs(int[] nums, int low, int high) {
        int counter = 0;
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                int xor = nums[i]^nums[j];
                if (xor < low) continue;
                if (xor > high) continue;
                counter++;
            }
        }

        return counter;
    }

}
