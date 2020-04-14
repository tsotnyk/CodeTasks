package com.j2core.sts.leetcode.com.arrays.contiguousArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    @Test
    public void test(){

//        Assert.assertEquals(findMaxLength(new int[]{0,0,0,1,1,1,0}), 6);
        Assert.assertEquals(findMaxLength(new int[]{0,0,1,0,0,0,1,1}), 6);

    }
}
