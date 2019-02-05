package com.j2core.sts.leetcode.com.hammingDistance;

import org.testng.Assert;

public class Solution {
    public int hammingDistance(int x, int y) {

        if (x == y) return 0;

        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);

        String small = X.length() <= Y.length() ? X : Y;
        String big = Y.length() >= X.length() ? Y : X;

        int delta = big.length() - small.length();
        int index = 0;
        int count = 0;

        while (index < delta){

            if (big.charAt(index) == '1'){
                count++;
            }
            index++;
        }

        while (index < big.length()){

            if (big.charAt(index) != small.charAt(index-delta)){
                count++;
            }
            index++;

        }

        return count;
    }


    @org.testng.annotations.Test
    public void test(){

        int result = hammingDistance(1, 4);

        Assert.assertEquals(result, 2);

    }
}
