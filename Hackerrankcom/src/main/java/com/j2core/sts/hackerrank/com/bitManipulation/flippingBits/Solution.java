package com.j2core.sts.hackerrank.com.bitManipulation.flippingBits;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    long flippingBits(long n) {

        long num = ~1;
        num = num>>32;
        num = num<<32;
        num = num^n;
        return ~num;
    }

    @Test

    public void test(){

        Assert.assertEquals(4294967286L, flippingBits(9));
    }


}
