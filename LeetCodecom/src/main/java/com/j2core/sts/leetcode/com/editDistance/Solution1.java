package com.j2core.sts.leetcode.com.editDistance;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int minDistance(String word1, String word2) {

        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int[][] mat = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < mat.length; i++){
            mat[i][0] = i;
        }

        for (int i = 0; i < mat[0].length; i++){
            mat[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1];
                }else {
                    mat[i][j] = Math.min(Math.min(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1])+1;
                }
            }
        }

        return mat[word1.length()][word2.length()];
    }

    @Test
    public void test(){

        Assert.assertEquals(minDistance("horse", "ros"), 3);
    }
}
