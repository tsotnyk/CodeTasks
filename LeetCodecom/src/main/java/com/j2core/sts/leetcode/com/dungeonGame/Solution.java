package com.j2core.sts.leetcode.com.dungeonGame;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n+1];

        //Initialize the matrix to maximum possible.
        for (int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[n - 1] = 1;

        for(int i = m - 1; i >= 0; --i)
            for(int j = n - 1; j >= 0; --j){
                int minHp = Math.min(dp[j], dp[j + 1])- dungeon[i][j];
                dp[j] = (minHp <= 0) ? 1 : minHp;
            }
        return dp[0];
    }

    @Test
    public void test(){

        int result = calculateMinimumHP(new int[][]{{2,0,-1}});

        Assert.assertEquals(result, 1);
    }
}
