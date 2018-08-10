package com.j2core.sts.leetcode.com.arrays.stoneGame;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean stoneGame(int[] piles) {

        int sumA = 0;
        int sumL = 0;
        int firstIndex = piles.length/2 - 1;
        int lastIndex = piles.length/2;


        while (firstIndex  > -1){

            sumA = sumA + Math.max(piles[firstIndex], piles[lastIndex]);
            sumL = sumL + Math.min(piles[firstIndex--], piles[lastIndex++]);

        }

        return sumA > sumL;

    }

    public boolean stoneGame1(int[] piles){

        return true;
    }


    @Test
    public void test(){

        boolean result = stoneGame(new int[]{5,3,4,5});

        Assert.assertTrue(result);

        boolean result1 = stoneGame(new int[]{3,2,10,4});

        Assert.assertTrue(result1);

    }

}
