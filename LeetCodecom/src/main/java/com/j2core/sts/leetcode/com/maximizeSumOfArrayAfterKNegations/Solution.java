package com.j2core.sts.leetcode.com.maximizeSumOfArrayAfterKNegations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Solution {

    public int largestSumAfterKNegations(int[] A, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : A){
            priorityQueue.add(num);
        }

        while (K-- > 0){
            int num = priorityQueue.poll();
            priorityQueue.add(-num);
        }

        int sum = 0;
        for (int num : priorityQueue){
            sum += num;
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(largestSumAfterKNegations(new int[]{4,2,3}, 1), 5);
    }
}
