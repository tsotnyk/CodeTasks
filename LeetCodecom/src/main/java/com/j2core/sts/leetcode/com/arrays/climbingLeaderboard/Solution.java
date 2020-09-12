package com.j2core.sts.leetcode.com.arrays.climbingLeaderboard;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        ArrayList<Integer> numList = new ArrayList<>();
        int num = scores[0];
        numList.add(num);
        for (int i = 1; i < scores.length; i++){
            if (scores[i] != num){
                num = scores[i];
                numList.add(num);
            }
        }
        int index = numList.size()-1;
        int[] aliceScope = new int[alice.length];
        for (int i = 0; i < alice.length; i++){
            for (int j = index; j >=  -1; j--){
                if (j == -1 || numList.get(j) > alice[i]){
                    index = j;
                    break;
                }
            }
            aliceScope[i] = 1 + index+1;
        }

        return aliceScope;
    }

    @Test
    public void test(){

        Assert.assertEquals(climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5,25,50,120}), new int[]{6,4,2,1});
    }
}
