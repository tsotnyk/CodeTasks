package com.j2core.sts.leetcode.com.arrays.teemoAttacking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries.length < 1) return 0;

        int time = 0;

        if (timeSeries.length == 1){
            time = duration;
        }else {

            int step = timeSeries[0];

            for (int i = 1; i < timeSeries.length; i++){

                int nextStep = timeSeries[i];
                if (nextStep-step < duration){

                    time = time + nextStep - step;
                    step = nextStep;
                }else {

                    time = time + duration;
                    step = nextStep;
                }
            }
            time = time + duration;
        }

        return time;
    }

    @Test
    public void test(){

        int result = findPoisonedDuration(new int[]{1,4}, 2);
        Assert.assertEquals(result, 4);

        int result1 = findPoisonedDuration(new int[]{1,2}, 2);
        Assert.assertEquals(result1, 3);

        int result2 = findPoisonedDuration(new int[]{1,2,3,4,5}, 5);
        Assert.assertEquals(result2, 9);

    }

}
