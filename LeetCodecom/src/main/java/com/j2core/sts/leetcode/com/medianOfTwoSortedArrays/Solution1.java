package com.j2core.sts.leetcode.com.medianOfTwoSortedArrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        boolean h = length % 2 == 0;

        int steps = length/2;
        if (h) steps-=1;
        int index1 = 0;
        int index2 = 0;

        while (steps > 0 && index1 < nums1.length && index2 < nums2.length ){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else {
                index2++;
            }
            steps--;
        }

        if (steps == 0){
            if (!h){
                if (index1 < nums1.length && index2 < nums2.length){
                    return Math.min(nums1[index1],nums2[index2]);
                }
                return index1 == nums1.length ? nums2[index2] : nums1[index1];
            }
            int first;
            int second;
            if (index1 < nums1.length && index2 < nums2.length){
                if (nums1[index1] < nums2[index2]){
                    first = nums1[index1++];
                }else {
                    first = nums2[index2++];
                }
                if (index1 < nums1.length && index2 < nums2.length){
                    second = Math.min(nums1[index1],nums2[index2]);
                }else {
                    second = index1 ==nums1.length ? nums2[index2] : nums1[index1];
                }
                return ((double) first+second)/2.0;
            }
            if (index1 == nums1.length){
                first = nums2[index2++];
                second = nums2[index2];
            }else {
                first = nums1[index1++];
                second = nums1[index1];
            }
            return ((double) first+second)/2.0;
        }

        int index;
        int[] nums;
        if (index1 == nums1.length){
            index = index2;
            nums = nums2;
        }else {
            index = index1;
            nums = nums1;
        }

        if (h){
            return nums[index];
        }

        return ((double) nums[index++]+nums[index])/2.0;
    }

    @Test
    public void test(){
        Assert.assertEquals(findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4}), 2.5);

        Assert.assertEquals(findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2.0);
        Assert.assertEquals(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5);
    }
}
