package com.j2core.sts.leetcode.com.uglyNumberII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int nthUglyNumber(int n) {

        if (n < 4) return n;

        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int index = 1;

        while (index < n){

            int num2 = 2*uglyNums[index2];
            int num3 = 3*uglyNums[index3];
            int num5 = 5*uglyNums[index5];

            int min = Math.min(Math.min(num2, num3), num5);
            uglyNums[index++] = min;

            if (num2 == min) index2++;
            if (num3 == min) index3++;
            if (num5 == min) index5++;
        }

        return uglyNums[n-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(nthUglyNumber(10), 12);
        Assert.assertEquals(nthUglyNumber(11), 15);


    }
}
