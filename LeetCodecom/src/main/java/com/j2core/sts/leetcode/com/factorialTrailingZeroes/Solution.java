package com.j2core.sts.leetcode.com.factorialTrailingZeroes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int trailingZeroes(int n) {

        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }

    @Test
    public void test(){

        Assert.assertEquals(trailingZeroes(30), 7);
    }
}
