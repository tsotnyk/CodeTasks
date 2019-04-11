package com.j2core.sts.leetcode.com.regularExpressionMatching;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isMatchNew(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch(String s, String p) {

        return isMatchHelper(s,0, p,0);

    }

    private boolean isMatchHelper(String str,int indexStr,String pattern,int indexPat) {

        if( indexPat == pattern.length()) {

            return indexStr == str.length();
        }

        char patChar;

        if(indexPat < pattern.length()-1 && pattern.charAt(indexPat+1) == '*') {

            patChar = pattern.charAt(indexPat);
            if(indexStr < str.length() && (patChar == '.' || str.charAt(indexStr) == patChar)){

                if(isMatchHelper(str,indexStr+1, pattern, indexPat)){
                    return true;
                }
            }

            return isMatchHelper(str, indexStr, pattern, indexPat+2);

        }

        patChar = pattern.charAt(indexPat);

        if(indexStr < str.length() && str.charAt(indexStr) == patChar || patChar == '.') {

            return isMatchHelper(str,indexStr+1, pattern,indexPat+1);
        }

        return false;
    }


    @Test
    public void test(){

        Assert.assertTrue(isMatch("aa", "a*"));

    }
}
