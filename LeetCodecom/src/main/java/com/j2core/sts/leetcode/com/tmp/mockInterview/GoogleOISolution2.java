package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GoogleOISolution2 {

    public int numSquares(int n) {

        List<Integer> candidates = new LinkedList<>();
        int num = 2;
        while (num*num <= n){
            candidates.add(num*num);
            num++;
        }

        int[] dp = new int[n+1];

        for (int i = 0; i < dp.length; i++){
            dp[i] = i;
        }

        for (int i = 1; i < dp.length; i++){
            for (int candidate : candidates) {
                if (candidate > i) break;
                dp[i] = Math.min(dp[i - candidate] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    @Test
    public void testNumSquares(){

        Assert.assertEquals(3, numSquares(12));
    }

    public int assignBikes(int[][] workers, int[][] bikes) {


        return 0;
    }
}
