package com.j2core.sts.leetcode.com.maximumDistanceBetweenPairOfValues;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int maxDistance(int[] nums1, int[] nums2) {

        int maxDelta = 0;
        int i = 0;
        int j;

        while (i < nums1.length){

            j = i+maxDelta+1;
            int counter = 0;
            while (j < nums2.length && nums1[i] <= nums2[j]){
                counter++;
                j++;
            }
            maxDelta += counter;
            i++;
        }

        return maxDelta;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}), 2);
        Assert.assertEquals(maxDistance(new int[]{2,2,2}, new int[]{10,10,1}), 1);
        Assert.assertEquals(maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}), 2);
        Assert.assertEquals(maxDistance(new int[]{5,4}, new int[]{3,2}), 0);

    }
}
