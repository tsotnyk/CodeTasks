package com.j2core.sts.leetcode.com.gasStation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int canCompleteCircuitOld(int[] gas, int[] cost) {

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

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++){

            if (gas[i] >= cost[i]){
                if (isCorrectRoad(gas, cost, i)) return i;
            }
        }

        return -1;
    }

    private boolean isCorrectRoad(int[] gas, int[] cost, int index){

        int counter = gas.length;
        int sum = 0;
        while (counter-- > 0){
            if (index == gas.length){
                index = 0;
            }
            sum = sum + gas[index] - cost[index];
            if (sum < 0) return false;
            index++;
        }

        return true;
    }

    public int canCompleteCircuitNew(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];

            tank += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return sumGas < sumCost ? -1 : start;
    }

    @Test
    public void test(){

        int index = canCompleteCircuitNew(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});

        Assert.assertTrue(index == 3);
//
//        int index1 = canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
//
//        Assert.assertTrue(index1 == -1);

        Assert.assertEquals(canCompleteCircuit(new int[]{2}, new int[]{2}), 0);

    }

}
