package com.j2core.sts.leetcode.com.possibleBipartition;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] matrix = new int[N+1][N+1];
        for (int[] pair : dislikes) {
            int i = pair[0];
            int j = pair[1];
            matrix[i][j] = 1;
            matrix[j][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            if (matrix[i][i] == 0 && !dfs(matrix, 2, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] matrix, int color, int i) {
        matrix[i][i] = color;
        for (int j = 1; j < matrix.length; j++) {
            if (i != j && matrix[i][j] != 0 && matrix[j][j] != -color) {
                if (matrix[j][j] == color){
                    return false;
                }
                if (!dfs(matrix, -color, j)){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
    }

}
