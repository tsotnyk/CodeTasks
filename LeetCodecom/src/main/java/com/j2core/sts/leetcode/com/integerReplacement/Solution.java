package com.j2core.sts.leetcode.com.integerReplacement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int integerReplacement(int n) {

        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement(n/2);
        } else {
            return 2 + Math.min(integerReplacement(n/2 + 1), integerReplacement(n/2));
        }
    }

    @Test
    public void test(){
        Assert.assertEquals(integerReplacement(3), 2);
        Assert.assertEquals(integerReplacement(4), 2);
        Assert.assertEquals(integerReplacement(8), 3);
        Assert.assertEquals(integerReplacement(7), 4);
        Assert.assertEquals(integerReplacement(1234), 14);
        Assert.assertEquals(integerReplacement(65535), 17);
        Assert.assertEquals(integerReplacement(10000), 16);

    }
}
