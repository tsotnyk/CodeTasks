package com.j2core.sts.leetcode.com.palindromePartitioningII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minCut(String s) {

        int[][] dp = new int[s.length()+1][s.length()+1];
        String reversWord = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length(); i++){
            dp[0][i] = i;
        }
        for (int i = 0; i <= s.length(); i++){
            dp[i][0] = i;
        }

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j < s.length(); j++){
                if (s.charAt(i-1) == reversWord.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return s.length() - (dp[s.length()][s.length()]/2);
    }

    @Test

    public void test(){

        Assert.assertEquals(minCut("aab"), 1);
    }
}
