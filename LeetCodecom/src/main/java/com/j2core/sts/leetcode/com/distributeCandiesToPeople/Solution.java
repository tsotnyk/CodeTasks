package com.j2core.sts.leetcode.com.distributeCandiesToPeople;

public class Solution {

    public int[] distributeCandies(int candies, int num_people) {

        int[] result = new int[num_people];
        int index = 0;
        int amountCandy = 1;

        while (amountCandy <= candies){

            result[index] += amountCandy;
            index++;
            candies -= amountCandy++;

            if (index == num_people){
                index = 0;
            }
        }

        if (candies != 0){
            result[index] += candies;
        }

        return result;
    }
}
