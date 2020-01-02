package com.j2core.sts.leetcode.com.sumOfMutatedArrayClosestToTarget;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);
        return getMinNumber(arr, target);
    }

    private int getMinNumber(int[] array, int target){
        int length = array.length;
        int minSum;
        if (target%length == 0){
            minSum = target/length;
        }else {
            int tmp = target/length;
            minSum = target - tmp*length <= (tmp+1)*length - target ? tmp : tmp+1;
        }

        if (minSum <= array[0]){
            return minSum;
        }

        return findBestValue(Arrays.copyOfRange(array, 1, length), target-array[0]);

    }

    @Test
    public void test(){

        Assert.assertEquals(findBestValue(new int[]{3,4,9}, 10), 3);
        Assert.assertEquals(findBestValue(new int[]{2,3,5}, 10), 5);
        Assert.assertEquals(findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803), 11361);
        Assert.assertEquals(findBestValue(new int[]{48772,52931,14253,32289,75263},40876), 8175);
        Assert.assertEquals(findBestValue(new int[]{1547,83230,57084,93444,70879}, 71237), 17422);

    }
}
