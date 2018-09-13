package com.j2core.sts.leetcode.com.waterAndJugProblem;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution{

    public boolean canMeasureWater(int x, int y, int z) {

        Boolean result = preCheckData(x, y, z);

        if (result != null) {

            return result;

        }

        int delta = countDelta(x, y);

        return z%delta == 0;

    }


    private int countDelta(int a, int b){

        while (b != 0){

            int tmp = b;
            b = a%b;
            a = tmp;

        }
        return a;
    }


    private Boolean preCheckData(int x, int y, int z) {

        if (z == 0 || y == z || x == z || x+y == z) return true;

        if (x + y < z) return false;

        return null;

    }


    @Test
    public void test() {

        boolean result = canMeasureWater(34, 5, 6);

        Assert.assertTrue(result);

        boolean result2 = canMeasureWater(34, 5, 6);

        Assert.assertTrue(result2);

        boolean result5 = canMeasureWater(13, 11, 1);

        Assert.assertTrue(result5);

        boolean result1 = canMeasureWater(0, 2, 5);

        Assert.assertFalse(result1);


        boolean result3 = canMeasureWater(1, 1, 12);

        Assert.assertFalse(result3);
    }

}
