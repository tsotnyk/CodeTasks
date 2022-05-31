package com.j2core.sts.leetcode.com.tmp.mockInterview.googlePI;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLength = 1;
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        for (int i = nums.length-2; i > -1; i--){
            if (nums[i+1] > nums[i]){
                dp[i] = 1+dp[i+1];
            }else {
                dp[i] = 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public int getMaximumGold(int[][] grid) {

        int maxSum = 0;
        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[0].length; j++){
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                maxSum = Math.max(countMaxGoldSum(grid, i, j, visited), maxSum);
            }
        }
        return maxSum;
    }

    private int countMaxGoldSum(int[][] grid, int i, int j, boolean[][] visited) {

        if (grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;

        int sum = 0;

        if (i-1 > -1){
            sum = Math.max(sum, countMaxGoldSum(grid, i-1, j, visited));
        }
        if (j-1 > -1){
            sum = Math.max(sum, countMaxGoldSum(grid, i, j-1, visited));
        }
        if (i+1 < grid.length){
            sum = Math.max(sum, countMaxGoldSum(grid, i+1, j, visited));
        }
        if (j+1 < grid[0].length){
            sum = Math.max(sum, countMaxGoldSum(grid, i, j+1, visited));
        }

        visited[i][j] = false;
        return grid[i][j]+sum;
    }
    int [] rows = new int[]{0,-1,0,1};
    int [] cols = new int[]{-1,0,1,0};

    public int getMaximumGold1(int[][] grid) {

        int result = Integer.MIN_VALUE;
        int [][] visited = new int[grid.length][grid[0].length];

        for (int i = 0 ; i < grid.length ; i++){
            Arrays.fill(visited[i],-1);
        }

        for (int i = 0 ; i < grid.length ; i++)
        {
            for (int j = 0 ; j < grid[0].length ; j++)
            {
                int sum = 0;
                if(visited[i][j] == -1 && grid[i][j] != 0)
                {
                    result = Math.max(result,dfs(i, j,grid, visited));
                }
            }
        }

        return result;
    }

    public int dfs(int row, int col, int [][] grid, int[][] visited)
    {

        visited[row][col] = 1;
        int sum = 0;

        for (int i = 0 ; i <= 3 ; i++)
        {
            int x = row + rows[i];
            int y = col + cols[i];

            if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length)
            {
                if (visited[x][y] != 1)
                {
                    if(grid[x][y] != 0)
                    {
                        sum = Math.max(sum, dfs(x, y, grid, visited));
                    }
                }

            }
        }

        sum += grid[row][col];
        visited[row][col] = -1;

        return sum ;
    }

    @Test
    public void test(){

//        Assert.assertEquals(24, getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
//        Assert.assertEquals(28, getMaximumGold(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
        Assert.assertEquals(478, getMaximumGold(new int[][]{{0,0,0,22,0,24},{34,23,18,0,23,2},{11,39,20,12,0,0},{39,8,0,2,0,1},{19,32,26,20,20,30},{0,38,26,0,29,31}}));

    }
}
