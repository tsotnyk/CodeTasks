package com.j2core.sts.leetcode.com.tmp.mockInterview;


import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BloombergOASolution1 {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target) return i;
        }

        return nums.length;
    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] visitedCity = new boolean[isConnected.length];
        int counter = 0;
        int city = getUnVisitedCity(visitedCity);
        Stack<Integer> stack = new Stack<>();
        while (city < isConnected.length){
            counter++;
            stack.add(city);
            visitedCity[city] = true;
            while (!stack.isEmpty()){
                int nextCity = stack.pop();
                for (int i = 0; i < isConnected.length; i++){
                    if (i != nextCity && isConnected[nextCity][i] == 1 && !visitedCity[i]){
                        visitedCity[i] = true;
                        stack.add(i);
                    }
                }
            }
            city = getUnVisitedCity(visitedCity);
        }
        return counter;
    }

    private int getUnVisitedCity(boolean[] visitedCity){

        for (int i = 0; i < visitedCity.length; i++){
            if (!visitedCity[i]) return i;
        }
        return visitedCity.length;
    }

    @Test
    public void test(){

        Assert.assertEquals(2, findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        Assert.assertEquals(3, findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));

    }
}
