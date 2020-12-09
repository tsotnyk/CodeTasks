package com.j2core.sts.leetcode.com.coloringABorder;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        int curColor = grid[r0][c0];
        boolean[][] visitedPoints = new boolean[grid.length][grid[0].length];

        List<int[]> listOfWork = new LinkedList<>();
        listOfWork.add(new int[]{r0, c0});

        while (!listOfWork.isEmpty()){
            checkingWorkPoint(grid, listOfWork, curColor, color, visitedPoints);
        }

        return grid;
    }

    private void checkingWorkPoint(int[][] grid, List<int[]> listOfWork, int curColor, int newColor, boolean[][] visitedPoints){

        boolean changeColor = false;
        int[] workPoint = listOfWork.remove(0);
        int x = workPoint[0];
        int y = workPoint[1];
        visitedPoints[x][y] = true;

        if (x-1 < 0){
            changeColor = true;
        }else if (!visitedPoints[x-1][y]){
            if (grid[x-1][y] != curColor){
                changeColor = true;
            }else {
                listOfWork.add(new int[]{x-1, y});
            }
        }
        if (x+1 < grid.length){
            if (!visitedPoints[x+1][y]){
                if (grid[x+1][y] != curColor){
                    changeColor = true;
                }else {
                    listOfWork.add(new int[]{x+1, y});
                }
            }
        }else changeColor = true;
        if (y-1 > -1){
            if (!visitedPoints[x][y-1]){
                if (grid[x][y-1] != curColor){
                    changeColor = true;
                }else {
                    listOfWork.add(new int[]{x,y-1});
                }
            }
        }else {
            changeColor = true;
        }
        if (y+1 < grid[0].length){
            if (!visitedPoints[x][y+1]){
                if (grid[x][y+1] != curColor){
                    changeColor = true;
                }else {
                    listOfWork.add(new int[]{x,y+1});
                }
            }
        }else {
            changeColor = true;
        }
        if (changeColor){
            grid[x][y] = newColor;
        }
    }

    @Test
    public void test(){

        int[][] matrix1 = new int[][]{{1,1},{1,2}};
        int[][] matrix2 = new int[][]{{1,2,2},{2,3,2}};
        int[][] matrix3 = new int[][]{{1,1,1},{1,1,1},{1,1,1}};

        colorBorder(matrix1, 0,0,3);
        colorBorder(matrix2, 0,1,3);
        colorBorder(matrix3, 1,1, 2);

        System.out.println("Yes");
    }

}
