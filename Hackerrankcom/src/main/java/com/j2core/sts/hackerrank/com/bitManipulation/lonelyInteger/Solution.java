package com.j2core.sts.hackerrank.com.bitManipulation.lonelyInteger;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    int lonelyinteger(int[] a) {

        int result = 0;
        for (int num : a){
            result ^= num;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, lonelyinteger(new int[]{1,2,3,4,3,2,1}));
    }
}
