package sts.avenueCode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution2LargestInArray {

    // Time - O(n)
    // Spase - O(1)
    public int findMaxSumOfPair(int[] array){

        int first = array[0];
        int second = first;

        for (int i = 1; i< array.length; i++){
            int candidate = array[i];
            if (candidate > first){
                second = first;
                first = candidate;
            }else if (candidate > second){
                second = candidate;
            }
        }

        return first+second;
    }

    // T - O()
    // S - O()
    public boolean findSumOfThreeEqualValue(int[] array, int value){

        // todo
        return false;
    }

    // T - O(n)
    // S - O(1)
    public int findMaxSumOfSubArray(int[] array){

        int sum = array[0];
        int maxSum = sum;

        for (int i = 1; i < array.length; i++){
            if (sum < 0){
                sum = 0;
            }
            sum += array[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // T - O(n)
    // S - O(1)
    public int findMaxSumOfRobins(int[] array){

        int index = array.length-1;
        int prevMax = 0;
        int currentMax = array[index--];

        while (index >= 0){
            int nextMax = Math.max(currentMax, array[index--]+prevMax);
            prevMax = currentMax;
            currentMax = nextMax;
        }

        return currentMax;
    }

    @Test
    public void test1(){

        Assert.assertEquals(findMaxSumOfRobins(new int[]{2,1,1,2}), 4);

        Assert.assertEquals(findMaxSumOfPair(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 8);
        Assert.assertEquals(findMaxSumOfSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
    }
}
