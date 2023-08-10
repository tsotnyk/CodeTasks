package sts.avenuCode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];

//        if (s.length() == 0) return 0;
//        if (s.length() == 1) return 1;
//        if (s.charAt(0) == s.charAt(s.length()-1)){
//            return 2 + longestPalindromeSubseq(s.substring(1, s.length()-1));
//        }
//
//        int leftExc = longestPalindromeSubseq(s.substring(1));
//        int rightExc = longestPalindromeSubseq(s.substring(0, s.length()-1));
//        int bothExc = longestPalindromeSubseq(s.substring(1, s.length()-1));
//
//        return Math.max(Math.max(leftExc, rightExc), bothExc);

    }

    @Test
    public void test(){

        Assert.assertEquals(longestPalindromeSubseq("bbbab"), 4);
    }

}
