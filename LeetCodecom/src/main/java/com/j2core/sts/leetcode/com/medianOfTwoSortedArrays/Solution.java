package com.j2core.sts.leetcode.com.medianOfTwoSortedArrays;

import org.testng.annotations.Test;

public class Solution {

    public double findMedianSortedArraysNew(int[] nums1, int[] nums2) {

       int sumLength = nums1.length + nums2.length;

       if (sumLength%2 == 0){

           return (findMedianValue(nums1, 0, nums2, 0, sumLength/2) + findMedianValue(nums1, 0, nums2, 0, (sumLength/2)+1))/2.0;
       }else {

           return findMedianValue(nums1,0 , nums2, 0,sumLength/2+1);

       }
    }



    private int findMedianValue(int[] array1, int startIndex1, int[] array2, int startIndex2, int index){

        if (startIndex1 >= array1.length){
            return array2[startIndex2+index-1];
        }

        if (startIndex2 >= array2.length){
            return array1[startIndex1+index-1];
        }

        if (index == 1){
            return Math.min(array1[startIndex1], array2[startIndex2]);
        }

        int halfA = startIndex1 + index / 2 - 1 < array1.length ? array1[startIndex1 + index / 2 - 1] : Integer.MAX_VALUE;
        int halfB = startIndex2 + index / 2 - 1 < array2.length ? array2[startIndex2 + index / 2 - 1] : Integer.MAX_VALUE;

        if (halfA < halfB){
            return findMedianValue(array1, startIndex1 + index / 2, array2, startIndex2, index - index / 2);
        }
        else{
            return findMedianValue(array1, startIndex1, array2, startIndex2 + index / 2, index - index / 2);
        }
    }






    @Test
    public void test(){

        double result = findMedianSortedArrays(new int[]{1,3}, new int[]{2});

        System.out.print(result);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] sumArray = createSumArray(nums1, nums2);
        int length = sumArray.length;

        if (length%2 != 0){

            return sumArray[length/2];
        }else {

            return (sumArray[(length/2)-1]+ sumArray[length/2])/2.0;
        }

    }

    private int[] createSumArray(int[] array1, int[] array2){

        int[] sumArray = new int[array1.length + array2.length];

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < array1.length && index2 < array2.length){

            sumArray[index++] = array1[index1] < array2[index2] ? array1[index1++] : array2[index2++];

        }

        if (index2 < array2.length){
            index1 = index2;
            array1 = array2;
        }

        while (index1 < array1.length){

            sumArray[index++] = array1[index1++];
        }

        return sumArray;
    }

}
