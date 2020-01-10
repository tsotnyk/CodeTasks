package com.j2core.sts.leetcode.com.canMakePalindromeFromSubstring;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new LinkedList<>();
        int[][] sum = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[i + 1][j] = sum[i][j];
            }
            sum[i + 1][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int changes = queries[i][2];
            int count = 0;
            for (int j = 0; j < 26; j++) {
                int total = sum[end + 1][j] - sum[start][j];
                count += total%2;
            }
            result.add(count/2 <= changes);
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(canMakePaliQueries("hunu", new int[][]{{1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},
                {3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}}).size(), 13);
    }
}
