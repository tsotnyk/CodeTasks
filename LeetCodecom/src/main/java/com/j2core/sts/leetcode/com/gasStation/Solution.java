package com.j2core.sts.leetcode.com.gasStation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++){

            if (isCircularRoute(gas, cost, i)) return i;

        }

        return -1;
    }


    private boolean isCircularRoute(int[] gas, int[] cost, int index){

        int arrayLength = gas.length;
        int baseGas = 0;
        int arrayIndex;

        for (int i = 0; i < arrayLength; i++){

            arrayIndex = index + i;
            if (arrayIndex >= arrayLength){
                arrayIndex = arrayIndex - arrayLength;
            }

            baseGas = baseGas + gas[arrayIndex] - cost[arrayIndex];

            if (baseGas < 0) return false;
        }

        return true;

    }


    @Test
    public void test(){

        int index = canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});

        Assert.assertTrue(index == 3);

        int index1 = canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});

        Assert.assertTrue(index1 == -1);

    }

}
