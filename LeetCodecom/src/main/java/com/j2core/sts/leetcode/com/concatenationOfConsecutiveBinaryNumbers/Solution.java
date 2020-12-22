package com.j2core.sts.leetcode.com.concatenationOfConsecutiveBinaryNumbers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                result = (result * 2 + (binary.charAt(j) - '0')) % MOD;
            }
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(concatenatedBinary(1),1);
        Assert.assertEquals(concatenatedBinary(3), 27);
        Assert.assertEquals(concatenatedBinary(12), 505379714);
    }
}
