package com.j2core.sts.leetcode.com.medianOfTwoSortedArrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        int med = length/2;
        int in1 = 0;
        int in2 = 0;
        int steps = 0;
        while (steps < med && in1 < nums1.length && in2 < nums2.length){
            if (nums1[in1] < nums2[in2]){
                in1++;
            }else {
                in2++;
            }
            steps++;
        }

        if (steps < med){
            int[] arr;
            int in;
            if (in1 == nums1.length){
                arr = nums2;
                in = in2+med-steps;
            }else {
                arr = nums1;
                in = in1+med-steps;
            }

            if (length%2 != 0) return arr[in];
            return ((double) arr[in]+arr[in-1])/2.0;
        }

        if (length%2 != 0) return Math.min(nums1[in1], nums2[in2]);

        int first;
        int second;
        if (in1 == nums1.length){
            first = nums1[in1-1];
            second = nums2[in2];
        }else if( in2 == nums2.length){
            first = nums2[in2-1];
            second = nums1[in1];
        }else {
            if (nums1[in1] < nums2[in2]){
                first = nums1[in1--];
            }else {
                first = nums2[in2--];
            }
            if (in1 < 0){
                second = nums2[in2];
            }else if (in2 < 0){
                second = nums1[in1];
            }else {
                second = Math.min(nums1[in1], nums2[in2]);
            }
        }
            return ((double) first+second)/2.0;
    }

    @Test
    public void test(){
        Assert.assertEquals(findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4}), 2.5);

        Assert.assertEquals(findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2.0);
        Assert.assertEquals(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5);
    }
}
