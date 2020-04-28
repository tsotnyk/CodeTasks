package com.j2core.sts.leetcode.com.numberOfIslands;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int numIslands(char[][] grid) {

        int counter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    markIsland(grid, i, j);
                    counter++;
                }
            }
        }

        return counter;
    }

    public int numIslandsOld(char[][] grid) {

        int counter = 0;

        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == '1'){

                    counter++;
                    markIsland(grid, i, j);

                }
            }
        }

        return counter;
    }


    private void markIsland(char[][] grid, int i, int j){

        int iLength = grid.length;
        int jLength = grid[0].length;
        List<Pair> pairList = new LinkedList<>();
        grid[i][j] = '2';
        pairList.add(new Pair(i, j));

        while (!pairList.isEmpty()){

            Pair tmpPair = ((LinkedList<Pair>) pairList).removeFirst();

            int iIndex = tmpPair.i;
            int jIndex = tmpPair.j;

            if (jIndex+1 < jLength && grid[iIndex][jIndex+1] == '1'){
                grid[iIndex][jIndex+1] = '2';
                pairList.add(new Pair(iIndex, jIndex+1));
            }
            if (jIndex-1 > -1 && grid[iIndex][jIndex-1] == '1'){
                grid[iIndex][jIndex-1] = '2';
                pairList.add(new Pair(iIndex, jIndex-1));
            }
            if (iIndex+1 < iLength && grid[iIndex+1][jIndex] == '1'){
                grid[iIndex+1][jIndex] = '2';
                pairList.add(new Pair(iIndex+1, jIndex));
            }
            if (iIndex-1 > -1 && grid[iIndex-1][jIndex] == '1'){
                grid[iIndex-1][jIndex] = '2';
                pairList.add(new Pair(iIndex-1, jIndex));
            }
        }
    }

    class Pair{

        public int i;
        public int j;

        protected Pair(int i, int j){

            this.i = i;
            this.j = j;
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(1, numIslands(new char[][]{{'1', '1', '1', '1', '0'},{'1', '1', '0', '1', '0'},{'1', '1', '0', '0', '0'},{'0', '0', '0', '0', '0'}}));

        Assert.assertEquals(3, numIslands(new char[][]{{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'},{'0', '0', '1', '0', '0'},{'0', '0', '0', '1', '1'}}));
        Assert.assertEquals(1, numIslands(new char[][]{{'1', '1', '1'},{ '0', '1', '0'},{'0', '1', '0'}}));
        Assert.assertEquals(1, numIslands(new char[][]{{'1', '1', '1'},{ '0', '1', '0'},{'1', '1', '1'}}));


    }

}
