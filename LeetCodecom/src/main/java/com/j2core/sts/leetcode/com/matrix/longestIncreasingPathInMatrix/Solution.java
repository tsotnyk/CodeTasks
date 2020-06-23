package com.j2core.sts.leetcode.com.matrix.longestIncreasingPathInMatrix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxPath = 0;

        int[][] pathMatrix = new int[matrix.length][matrix[0].length];
        for (int[] nums : pathMatrix) {
            Arrays.fill(nums, -1);
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int path = findPath(matrix, i, j, null, pathMatrix);
                if (path > maxPath) maxPath = path;
            }
        }

        return maxPath;
    }

    private int findPath(int[][] matrix, int i, int j, Integer prevNum, int[][] pathMatrix) {

        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) return 0;
        if (prevNum != null) {
            if (matrix[i][j] >= prevNum) return 0;
        }
        if (pathMatrix[i][j] > -1){
            return pathMatrix[i][j];
        }

        int path = 0;
        int upPath = findPath(matrix, i-1, j, matrix[i][j], pathMatrix);
        if (path < upPath) path = upPath;
        int downPath = findPath(matrix, i+1, j, matrix[i][j], pathMatrix);
        if (path < downPath) path = downPath;
        int leftPath = findPath(matrix, i, j-1, matrix[i][j], pathMatrix);
        if (path < leftPath) path = leftPath;
        int rightPath = findPath(matrix, i, j+1, matrix[i][j], pathMatrix);
        if (rightPath > path) path = rightPath;

        pathMatrix[i][j] = path+1;
        return path+1;
    }

    @Test
    public void test(){

        Assert.assertEquals(longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}), 4);
        Assert.assertEquals(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}), 4);

    }
}
