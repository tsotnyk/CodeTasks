package com.j2core.sts.leetcode.com.deleteOperationForTwoStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minDistanceOld(String str1, String str2) {

        int len1=str1.length();
        int len2 = str2.length();
        int [][] result = new int [len1+1][len2+1];

        for(int i=1;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    result[i][j] = result[i-1][j-1]+1;
                else
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
            }
        }
        return (len1+len2) -(result[result.length-1][result[0].length-1]*2);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    @Test
    public void test(){

        Assert.assertEquals(minDistance("at", "cat"), 1);
        Assert.assertEquals(minDistance("boat", "got"), 3);
        Assert.assertEquals(minDistance("thought", "sloughs"), 6);

    }
}
