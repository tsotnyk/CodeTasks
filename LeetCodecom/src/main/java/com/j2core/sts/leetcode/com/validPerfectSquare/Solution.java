package com.j2core.sts.leetcode.com.validPerfectSquare;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPerfectSquare(int num) {

        if (num < 2) return true;
        if (num < 4) return false;

        int dev = 2;
        int tmpDev = dev;
        int tmpSum = num/tmpDev;

        while (tmpSum > tmpDev){
            dev = tmpDev;
            tmpDev *= 2;
            tmpSum = num/tmpDev;
        }

        tmpDev = tmpDev*tmpDev < Integer.MAX_VALUE ? 46340 : tmpDev;

        if ( dev*dev == num || tmpDev*tmpDev == num) return true;

        while (++dev <= --tmpDev){
            int sum = dev*dev;
            if (sum == num){
                return true;
            }else if (sum > num){
                break;
            }
            tmpSum = tmpDev*tmpDev;

            if (tmpSum == num){
                return true;
            }else if (tmpSum < num){
                break;
            }
        }
        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPerfectSquare(2147395600));
        Assert.assertFalse(isPerfectSquare(681));

        Assert.assertFalse(isPerfectSquare(5));
        Assert.assertFalse(isPerfectSquare(14));
        Assert.assertTrue(isPerfectSquare(16));
        Assert.assertTrue(isPerfectSquare(1));

    }
}
