package com.j2core.sts.leetcode.com.matrix.islandPerimeter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int islandPerimeter(int[][] grid) {

        int counter = 0;
        int iLength = grid.length;
        int jLength = grid[0].length;

        for (int i = 0; i < iLength; i++){
            for (int j = 0; j < jLength; j++){
                if (grid[i][j] == 1){
                    if (i-1 == -1 || grid[i-1][j] != 1) counter++;
                    if (i+1 == iLength || grid[i+1][j] != 1) counter++;
                    if (j-1 == -1 || grid[i][j-1] != 1) counter++;
                    if (j+1 == jLength || grid[i][j+1] != 1) counter++;
                }
            }
        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(islandPerimeter(new int[][]{{1,1,0,0}}), 2);
    }
}
