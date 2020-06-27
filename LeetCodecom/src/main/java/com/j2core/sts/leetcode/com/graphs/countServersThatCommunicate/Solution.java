package com.j2core.sts.leetcode.com.graphs.countServersThatCommunicate;


public class Solution {

    public int countServers(int[][] grid) {

        int sumServers = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    sumServers += countLinesServers(grid, i, j);
                }
            }
        }

        return sumServers;
    }

    private int countLinesServers(int[][] grid, int i, int j) {
        int counter = 0;

        for (int k = 0; k < grid.length; k++){
            if (k != i && grid[k][j] == 1){
                counter++;
                break;
            }
        }
        if (counter == 0){
            for (int l = 0; l < grid[0].length; l++){
                if (l != j && grid[i][l] == 1){
                    counter++;
                    break;
                }
            }
        }

        return counter;
    }
}
