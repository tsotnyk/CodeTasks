package com.j2core.sts.leetcode.com.arrays.numberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int counter = 0;
        long sum = 0;
        int index = 0;

        for (int i = 0; i+k <= arr.length; i++){

            if (i == 0){
                while (index < k){
                    sum += arr[index++];
                }
            }else {
                sum -= arr[i-1];
                sum += arr[index++];
            }
            if ((double) sum/k >= threshold){
                counter++;
            }
        }

        return counter;

    }

    @Test
    public void test(){

        Assert.assertEquals(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3,4), 3);
        Assert.assertEquals(numOfSubarrays(new int[]{1,1,1,1,1,}, 1,0), 5);
        Assert.assertEquals(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3,5), 6);
        Assert.assertEquals(numOfSubarrays(new int[]{7,7,7,7,7,7,7}, 7,7), 1);
        Assert.assertEquals(numOfSubarrays(new int[]{4,4,4,4}, 4,1), 1);


    }
}
