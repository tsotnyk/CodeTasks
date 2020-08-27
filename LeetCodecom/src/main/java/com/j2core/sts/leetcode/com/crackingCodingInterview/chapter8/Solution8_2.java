package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution8_2 {

    public List<List<int[]>> findAllRobotPath(int[][] matrix){

        List<List<int[]>> result = new LinkedList<>();
        if (matrix == null || matrix.length < 1 || (matrix.length == 1 && matrix[0].length == 1) ||
         matrix[0][0] == 1) return result;

        List<List<int[]>>[][] pathMatrix = new List[matrix.length][matrix[0].length];
        List<List<int[]>> firstStep = new LinkedList<>();
        firstStep.add(new LinkedList<>());
        pathMatrix[0][0] = firstStep;
        List<List<int[]>> nextStep;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != 1){
                    if (i == 0){
                        if (j != 0) {
                            if (pathMatrix[i][j-1] != null){
                                nextStep = new LinkedList<>();
                                nextStep.addAll(pathMatrix[i][j-1]);
                                nextStep.get(0).add(new int[]{i, j-1});
                                pathMatrix[i][j] = nextStep;
                            }
                        }
                    }else if (j == 0){
                        if (pathMatrix[i-1][j] != null){
                            nextStep = new LinkedList<>();
                            nextStep.addAll(pathMatrix[i-1][j]);
                            nextStep.get(0).add(new int[]{i-1, j});
                            pathMatrix[i][j] = nextStep;
                        }
                    }else {
                        if (pathMatrix[i-1][j] == null && pathMatrix[i][j-1] == null){
                            continue;
                        }else {
                            nextStep = new LinkedList<>();
                            if (pathMatrix[i-1][j] != null){
                                for (List<int[]> tmpList : pathMatrix[i-1][j]){
                                    tmpList.add(new int[]{i-1, j});
                                }
                                nextStep.addAll(pathMatrix[i-1][j]);
                            }
                            if (pathMatrix[i][j] != null){
                                for (List<int[]> tmpList : pathMatrix[i][j-1]){
                                    tmpList.add(new int[]{i, j-1});
                                }
                                nextStep.addAll(pathMatrix[i][j-1]);
                            }
                            pathMatrix[i][j] = nextStep;
                        }
                    }
                }
            }
        }

        return pathMatrix[matrix.length-1][matrix[0].length-1];
    }

    @Test
    public void test(){


        int[][] matrix = new int[][]{{0,0,0,0,0,1,0},{0,0,0,0,0,1,0},{0,1,0,0,0,0,0},{1,1,1,0,1,1,1},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};

        List<List<int[]>> result = findAllRobotPath(matrix);

        Assert.assertFalse(result.isEmpty());
    }
}
