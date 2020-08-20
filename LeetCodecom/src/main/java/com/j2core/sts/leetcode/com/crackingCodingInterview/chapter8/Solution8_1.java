package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution8_1 {

    public int countWays(int n){

        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }

    public int countJumpPaths(int n, int[] jumps){

        if (n < 1) return 0;
        if (jumps.length < 1) return 0;

        int[] matrix = new int[n+1];
        matrix[0] = 1;

        for (int i = 1; i <= n; i++){
            int pathSum = 0;
            for (int j = 0; j < jumps.length; j++){
                if (jumps[j] > i) break;
                pathSum += matrix[i-jumps[j]];
            }
            matrix[i] = pathSum;
        }

        return matrix[n];
    }

    @Test
    public void test(){

        Assert.assertEquals(countWays(6), 24);
        Assert.assertEquals(countJumpPaths(6, new int[]{1,2,3}), 24);

    }
}
