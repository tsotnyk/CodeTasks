package com.j2core.sts.leetcode.com.arrays.longestConsecutiveSequence;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;

public class Solution {

    public int longestConsecutive(int[] nums) {

        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        Arrays.sort(nums);
        int maxSeq = 1;
        int num = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] == num){
                continue;
            }
            if (nums[i] == num + 1){
                counter++;
                num++;
            }else {
                maxSeq = Math.max(maxSeq, counter);
                counter = 1;
                num = nums[i];
            }
        }

        maxSeq = Math.max(maxSeq, counter);

        return maxSeq;
    }

    @Test
    public void test(){

        Assert.assertEquals(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}), 7);
        Assert.assertEquals(longestConsecutive(new int[]{0, -1}), 2);
        Assert.assertEquals(longestConsecutive(new int[]{0, 1, 1, 2}), 3);

    }
}
