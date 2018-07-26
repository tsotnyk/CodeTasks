package com.j2core.sts.leetcode.com.max.maxIncreaseToKeepCitySkyline;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int length = grid.length;
        int baseSum = 0;
        int newSum = 0;

        int[] maxColumn = new int[length];
        int[] maxRow = new int[length];

        for (int i = 0; i < length; i++){

            int maxTmp = 0;
            for (int j = 0; j < length; j++){
                int tmp = grid[i][j];
                baseSum = baseSum + tmp;
                if (maxTmp < tmp){
                    maxTmp = tmp;
                }
                if (maxRow[j] < tmp){
                    maxRow[j] = tmp;
                }

            }
            maxColumn[i] = maxTmp;
        }

        for (int i = 0; i < length; i++){

            for (int j = 0; j < length; j++){

                int tmp = Math.min(maxRow[i], maxColumn[j]);
                newSum = newSum + tmp;
            }
        }

        return newSum-baseSum;
    }


    @Test
    public void test(){

        int[][] data = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        int result = maxIncreaseKeepingSkyline(data);

        Assert.assertEquals(35, result);

    }

}
