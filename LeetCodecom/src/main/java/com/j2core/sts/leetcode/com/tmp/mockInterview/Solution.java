package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int countDayForRipen(int m, int n, int[][] grid){

        return countDayRipen(m, n, grid, 0);
    }

    public int countDayRipen(int m, int n, int[][] grid, int counter){

        int[][] newGrid = new int[n][m];
        boolean ripen = false;
        boolean unripeTomatoes = false;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 0){
                    unripeTomatoes = true;
                    if (i-1 > -1 && grid[i-1][j] == 1){
                        newGrid[i][j] = 1;
                        ripen = true;
                        continue;
                    }
                    if(i+1 < n && grid[i+1][j] == 1){
                        newGrid[i][j] = 1;
                        ripen = true;
                        continue;
                    }
                    if (j-1 > -1 && grid[i][j-1] == 1){
                        newGrid[i][j] = 1;
                        ripen = true;
                        continue;
                    }
                    if (j+1 < m && grid[i][j+1] == 1){
                        newGrid[i][j] = 1;
                        ripen = true;
                        continue;
                    }
                    newGrid[i][j] = 0;
                }else{
                    newGrid[i][j] = grid[i][j];
                }
            }
        }
        if (unripeTomatoes && !ripen) return -1;
        if (!unripeTomatoes) return counter;
        return countDayRipen(m,n, newGrid, counter+1);
    }

    @Test
    public void test(){

        int[][] matrix1 = new int[][]{
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1}
        };
        Assert.assertEquals(8, countDayForRipen(6,4, matrix1));

        int[][] matrix2 = new int[][]{
                {0,-1,0,0,0,0},
                {-1,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1}
        };
        Assert.assertEquals(-1, countDayForRipen(6,4, matrix2));

        int[][] matrix3 = new int[][]{
                {1,-1,0,0,0,0},
                {0,-1,0,0,0,0},
                {0,0,0,0,-1,0},
                {0,0,0,0,-1,1}
        };
        Assert.assertEquals(6, countDayForRipen(6,4, matrix3));

        int[][] matrix4 = new int[][]{
                {-1,1,0,0,0},
                {0,-1,-1,-1,0},
                {0,-1,-1,-1,0},
                {0,-1,-1,-1,0},
                {0,0,0,0,0}
        };
        Assert.assertEquals(14, countDayForRipen(5,5, matrix4));

        int[][] matrix5 = new int[][]{
                {1,-1},
                {-1,1},
        };
        Assert.assertEquals(0, countDayForRipen(2,2, matrix5));
    }
}
