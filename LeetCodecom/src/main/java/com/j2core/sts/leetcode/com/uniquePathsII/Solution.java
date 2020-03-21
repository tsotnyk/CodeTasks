package com.j2core.sts.leetcode.com.uniquePathsII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0;

        int iLength = obstacleGrid.length;
        int jLength = obstacleGrid[0].length;
        for (int i = 0; i < iLength; i++){
            for (int j = 0; j < jLength; j++){

                if (i == 0 && j == 0){
                    obstacleGrid[i][j] = 1;
                }else if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else if (i == 0 && j > 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                }else if (j == 0 && i > 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                }
                else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[iLength-1][jLength-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}), 2);
    }
}
