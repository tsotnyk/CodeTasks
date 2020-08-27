package com.j2core.sts.leetcode.com.arrays.maximumNumberOfCoinsYouCanGet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int maxCoins(int[] piles) {

        Arrays.sort(piles); // time complexity O(nlogn);

        int sum = 0;
        int right = piles.length-1;
        int left = 0;
        // time complexity O(n/3);
        while (right > left){
            sum += piles[right-1];
            right -= 2;
            left++;
        }

        // all time complexity is O(nlogn) and space complexity is O(1);
        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}), 18);
        Assert.assertEquals(maxCoins(new int[]{2,4,5}), 4);
        Assert.assertEquals(maxCoins(new int[]{2,4,1,2,7,8}), 9);

    }
}
