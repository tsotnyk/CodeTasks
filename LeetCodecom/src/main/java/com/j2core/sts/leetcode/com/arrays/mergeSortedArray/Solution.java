package com.j2core.sts.leetcode.com.arrays.mergeSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int firstIndex = 0;
        int nums2Length = n;
        while (n > 0) {

            if (firstIndex == m) {

                nums1[firstIndex] = nums2[nums2Length - n];
                m++;
                n--;

            } else if (nums1[firstIndex] > nums2[nums2Length - n]) {

                for (int i = m; i > firstIndex; i--) {

                    nums1[i] = nums1[i - 1];

                }

                nums1[firstIndex] = nums2[nums2Length - n];
                n--;
                m++;
            }
            firstIndex++;
        }
    }


    @Test
    public void test(){


        int[] nums1 = new int[]{1,2,3,0,0,0};

        merge(nums1, 3, new int[]{2,5,6}, 3);

        Assert.assertEquals(nums1, new int[]{1,2,2,3,5,6});

    }
}
