package com.j2core.sts.leetcode.com.peakIndexInMountainArray;

public class Solution {

    public int peakIndexInMountainArray(int[] A) {

        for (int i = 0; i < A.length-1; i++){

            if (A[i+1] < A[i]){
                return i;
            }
        }

        return 1;

    }
}
