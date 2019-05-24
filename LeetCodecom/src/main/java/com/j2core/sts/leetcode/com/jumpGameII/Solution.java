package com.j2core.sts.leetcode.com.jumpGameII;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public int jump(int[] nums) {

        if (nums != null && nums.length < 2)
            return 0;

        int index = 0;
        int jumps = 0;
        int maxRange = 0;
        int maxIndex = 0;

        while (true) {
            int i;
            for (i = index + 1; i < index + 1 + nums[index]; i++) {
                if (i == nums.length - 1) {
                    return ++jumps;
                }
                if (maxRange < i + nums[i]) {
                    maxRange = i + nums[i];
                    maxIndex = i;
                }
            }
            index = maxIndex;
            jumps++;
            if (maxRange > nums.length - 1) {
                return ++jumps;
            }
        }
    }

    @Test
    public void test(){

        Assert.assertEquals( 2, jump(new int[]{ 2, 3, 1, 1, 4}));
        Assert.assertEquals( 3, jump(new int[]{ 1, 1, 1, 1}));
        Assert.assertEquals( 4, jump(new int[]{ 1, 1, 1, 1, 1}));
        Assert.assertEquals( 3, jump(new int[]{ 2, 1, 1, 1, 1}));
        Assert.assertEquals( 2, jump(new int[]{ 1, 2, 3}));
        Assert.assertEquals( 2, jump(new int[]{ 2,0,2,0,1}));
        Assert.assertEquals(4, jump(new int[]{2,0,8,0,3,4,7,5,6,1,0,0,5,9,7,5,3,6}));

    }
}
