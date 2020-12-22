package com.j2core.sts.leetcode.com.minimumCostToMergeStones;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Solution {

    public int mergeStonesUncorect(int[] stones, int K) {

        ArrayList<Integer> piles = new ArrayList<>();
        for (int countStone : stones){
            piles.add(countStone);
        }

        int cost = 0;

        while (piles.size() >= K){
            cost += findMinKSubList(piles, K);
        }

        return piles.size() == 1 ? cost : -1;
    }

    private int findMinKSubList(ArrayList<Integer> piles, int k) {

        int[] sumArray = new int[piles.size()];

        for (int i = 0; i < piles.size(); i++){
            sumArray[i] = piles.get(i);
            int index = i-1;
            while (index > -1 && index > i-k){
                sumArray[index] += piles.get(i);
                index--;
            }
        }
        int index = 0;
        int minCost = sumArray[index];
        for (int j = 1; j <= sumArray.length-k; j++){
            if (minCost > sumArray[j]){
                minCost = sumArray[j];
                index = j;
            }
        }

        piles.set(index++, minCost);
        while (k-- > 1){
            piles.remove(index);
        }

        return minCost;
    }


    public int mergeStones(int[] stones, int K) {

        if (stones.length == 1) return 0;
        if (stones.length-K < 0) return -1;

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= stones.length-K; i++){
            int [] nextStones = new int[stones.length-K+1];
            int index = 0;
            for (int j = 0; j < stones.length; j++){
                if (j < i){
                    nextStones[index++] = stones[j];
                }else if (j >= i+K){
                    nextStones[++index] = stones[j];
                }else {
                    nextStones[index] += stones[j];
                }
            }
            int cost = nextStones[i];
            int nextCost = mergeStones(nextStones, K);
            if (nextCost == -1) return -1;
            minCost = Math.min(cost + nextCost, minCost);
        }

        return minCost;
    }

    public int mergeStones1(int[] stones, int K) {

        //todo

        return 0;
    }
    @Test
    public void test(){

//        Assert.assertEquals(mergeStones(new int[]{3,2,4,1},2), 20);
//        Assert.assertEquals(mergeStones(new int[]{3,2,4,1},3), -1);
//        Assert.assertEquals(mergeStones(new int[]{3,5,1,2,6},3), 25);
//        Assert.assertEquals(mergeStones(new int[]{6,4,4,6},2), 40);
        Assert.assertEquals(mergeStones(new int[]{10,1,1,10},2), 36);
    }
}
