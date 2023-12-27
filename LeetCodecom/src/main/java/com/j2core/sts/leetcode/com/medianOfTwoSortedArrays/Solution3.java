package com.j2core.sts.leetcode.com.medianOfTwoSortedArrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int median = (nums1.length + nums2.length)/2;
        AtomicInteger i1 = new AtomicInteger(0);
        AtomicInteger i2 = new AtomicInteger(0);

        if ((nums1.length+nums2.length)%2 == 0){
            median--;
            while (median-- > 0){
                getNext(nums1, nums2, i1, i2);
            }

            return (getNext(nums1, nums2, i1, i2)+getNext(nums1, nums2, i1, i2)) / 2.0;

        }else {
            while (median-- > 0){
               getNext(nums1, nums2, i1, i2);
            }
            return getNext(nums1, nums2, i1, i2);
        }
    }

    private double getNext(int[] nums1, int[] nums2, AtomicInteger i1, AtomicInteger i2){

        if(i1.get() >= nums1.length){
            return nums2[i2.getAndIncrement()];
        }
        if (i2.get() >= nums2.length){
            return nums1[i1.getAndIncrement()];
        }

        return nums1[i1.get()] <= nums2[i2.get()] ? nums1[i1.getAndIncrement()] : nums2[i2.getAndIncrement()];
    }

    @Test
    public void test(){
        Assert.assertEquals(findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4}), 2.5);

        Assert.assertEquals(findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2.0);
        Assert.assertEquals(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5);
    }
}
