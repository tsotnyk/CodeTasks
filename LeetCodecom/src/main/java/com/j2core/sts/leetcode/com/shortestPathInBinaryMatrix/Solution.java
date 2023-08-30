package com.j2core.sts.leetcode.com.shortestPathInBinaryMatrix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int iL = grid.length;
        int jL = grid[0].length;
        if (grid[0][0] == 1 || grid[iL-1][jL-1] == 1) return -1;
        int[][] mat = new int[iL][jL];

        for (int i = 0; i < iL; i++){
            for (int j = 0; j < jL; j++){
                mat[i][j] = Integer.MAX_VALUE;
            }
        }
        List<Task> taskList = new LinkedList<>(Collections.singletonList(new Task(0, 0, 1)));

        while (!taskList.isEmpty()){
            Task task = taskList.remove(0);
            nextStep(grid, task, mat, taskList);
        }

        return mat[iL-1][jL-1] < Integer.MAX_VALUE ? mat[iL-1][jL-1] : -1;
    }

    private void nextStep(int[][] grid, Task task, int[][] mat, List<Task> list){

        if (task.i < 0 || task.i >= grid.length || task.j < 0 || task.j >= grid[0].length || grid[task.i][task.j] == 1 || mat[task.i][task.j] <= task.steps) return;

        mat[task.i][task.j] = task.steps;

        list.add(new Task(task.i-1, task.j, task.steps+1));
        list.add(new Task(task.i, task.j-1, task.steps+1));
        list.add(new Task(task.i-1, task.j-1, task.steps+1));
        list.add(new Task(task.i-1, task.j+1, task.steps+1));
        list.add(new Task(task.i, task.j+1, task.steps+1));
        list.add(new Task(task.i+1, task.j-1, task.steps+1));
        list.add(new Task(task.i+1, task.j, task.steps+1));
        list.add(new Task(task.i+1, task.j+1, task.steps+1));
    }

    class Task{
        int i;
        int j;
        int steps;

        public Task(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }


    @Test
    public void test(){

        int[][] grid = new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };

        Assert.assertEquals(shortestPathBinaryMatrix(grid), 4);
    }
}
