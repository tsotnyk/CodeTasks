package com.j2core.sts.leetcode.com.string.wildcardMatching;

public class Solution {

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= n; j++) {
                if(dp[i][j]) {
                    if(p.charAt(i) == '*') {
                        dp[i+1][j] = true;
                        while(j < n) {
                            dp[i+1][j+1] = true;
                            j++;
                        }
                        break;
                    }else if(j < n && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) ) {
                        dp[i+1][j+1] = true;
                    }
                }
            }
        }

        return dp[m][n];
    }
}
