package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

public class OASolution1 {

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int profit = 0;
        int index = 2;
        while (index < nums.length){


        }

        return profit;
    }

    public int maxKilledEnemies(char[][] grid) {

        int counter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '0'){
                    int tmpCounter = 0;
                    for (int k = i+1; k < grid.length; k++){
                        if (grid[k][j] == 'E'){
                            tmpCounter++;
                            continue;
                        }
                        if (grid[k][j] == 'W') break;
                    }
                    for (int k = i-1; k > -1; k--){
                        if (grid[k][j] == 'E'){
                            tmpCounter++;
                            continue;
                        }
                        if (grid[k][j] == 'W') break;
                    }
                    for (int k = j+1; k < grid[0].length; k++){
                        if (grid[i][k] == 'E'){
                            tmpCounter++;
                            continue;
                        }
                        if (grid[i][k] == 'W') break;
                    }
                    for (int k = j-1; k > -1; k--){
                        if (grid[i][k] == 'E'){
                            tmpCounter++;
                            continue;
                        }
                        if (grid[i][k] == 'W') break;
                    }
                    counter = Math.max(counter, tmpCounter);
                }
            }
        }

        return counter;
    }

    @Test
    public void test2(){

        Assert.assertEquals(maxKilledEnemies(new char[][]{{'0','0','0'}}), 0);

        Assert.assertEquals(maxKilledEnemies(new char[][]{{'0'},{'0'},{'0'}}), 0);

        Assert.assertEquals(maxKilledEnemies(new char[][]{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}}), 3);
    }

}
