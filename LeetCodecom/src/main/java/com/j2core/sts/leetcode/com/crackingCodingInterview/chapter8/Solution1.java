package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int countWays(int n){

        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }

    @Test
    public void test(){

        Assert.assertEquals(countWays(6), 24);
    }
}
