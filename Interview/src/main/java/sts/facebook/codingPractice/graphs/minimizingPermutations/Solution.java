package sts.facebook.codingPractice.graphs.minimizingPermutations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    int minOperationsRecursion(int[] arr) {
        // Write your code here
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != i+1){
                int tmp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = tmp;
                return 1 + minOperations(arr);
            }
        }
        return 0;
    }

    int minOperations(int[] arr) {
        // Write your code here
        int index = 0;
        int counterPermutations = 0;
        int unCorrectValue = 0;

        while (index < arr.length){

            if (arr[index] > 0 && arr[index] != index+1){
                counterPermutations++;
                if (arr[arr[index]-1] > 0 && arr[arr[index]-1] != index+1){
                    unCorrectValue++;
                }
                arr[arr[index]-1] *= -1;
                arr[index] *= -1;

            }
            index++;
        }

        return counterPermutations + (unCorrectValue/2);
    }

    @Test
    public void test(){

        Assert.assertEquals(minOperations(new int[]{3,1,2}), 2);
        Assert.assertEquals(minOperations(new int[]{4,5,3,2,1}), 3);
        Assert.assertEquals(minOperations(new int[]{1,2,3,4,5}), 0);
        Assert.assertEquals(minOperations(new int[]{5,4,3,2,1}), 2);
        Assert.assertEquals(minOperations(new int[]{1,2,5,4,3}), 1);
        Assert.assertEquals(minOperations(new int[]{1}), 0);
        Assert.assertEquals(minOperations(new int[]{1,2}), 0);
        Assert.assertEquals(minOperations(new int[]{2,1}), 1);

    }
}
