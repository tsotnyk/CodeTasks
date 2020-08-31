package com.j2core.sts.leetcode.com.arrays.findLatestGroupOfSizeM;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeSet;

public class Solution {

    public int findLatestStepTimeLimit(int[] arr, int m) {

        int latestStep = -1;
        int[] binaryString = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            binaryString[arr[i]-1] = 1;
            int counter = 0;
            for (int j = 0; j < binaryString.length; j++){
                if (binaryString[j] == 1){
                    counter++;
                }else {
                    if (counter == m) break;
                    counter = 0;
                }
            }

            if (counter == m) latestStep = i+1;
        }

        return latestStep;
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n)
            return n;

        TreeSet<Integer> walls = new TreeSet<Integer>();
        walls.add(0);
        walls.add(n + 1);

        for (int i = n - 1; i >= 0; i--) {
            int left = walls.floor(arr[i]);
            int right = walls.ceiling(arr[i]);
            if (arr[i] - left - 1 == m || right - arr[i] - 1 == m)
                return i;
            walls.add(arr[i]);
        }

        return -1;
    }
    @Test
    public void test(){

        Assert.assertEquals(findLatestStep(new int[]{2,1}, 2), 2);
        Assert.assertEquals(findLatestStep(new int[]{1}, 1), 1);
        Assert.assertEquals(findLatestStep(new int[]{1}, 2), -1);
        Assert.assertEquals(findLatestStep(new int[]{3,1,5,4,2}, 2), -1);
        Assert.assertEquals(findLatestStep(new int[]{3,5,1,2,4}, 1), 4);

    }
}
