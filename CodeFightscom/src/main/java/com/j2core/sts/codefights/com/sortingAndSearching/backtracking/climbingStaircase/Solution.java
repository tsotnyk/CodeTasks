package com.j2core.sts.codefights.com.sortingAndSearching.backtracking.climbingStaircase;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[][] climbingStaircase(int n, int k) {

        if (n == 0) return new int[0][0];

        List<List<Integer>> pathList = new LinkedList<>();

        //todo

        int[][] result = new int[pathList.size()][];
        int index = 0;
        for (List<Integer> list : pathList){
            result[index] = new int[list.size()];
            int tmpIndex = 0;
            for (int num : list){
                result[index][tmpIndex++] = num;
            }
            index++;
        }

        return result;
    }

    private List<List<Integer>> addPath(int steps, int jump, LinkedList<List<Integer>> pathList){


        return null;

    }
}
