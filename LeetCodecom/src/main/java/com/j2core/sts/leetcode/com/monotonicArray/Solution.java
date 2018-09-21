package com.j2core.sts.leetcode.com.monotonicArray;

import org.testng.annotations.Test;

public class Solution {


    public boolean isMonotonic(int[] A) {

        if (A.length < 2) {
            return true;
        }

        int index = 1;
        while (index < A.length && A[index-1] == A[index]){
            index++;
        }

        if (index >= A.length-1){
            return true;
        }else {

            boolean flag = A[index-1] < A[index];

            for (int i = index-1; i < A.length-1; i++) {

                int first, second;
                if (flag) {
                    first = A[i];
                    second = A[i + 1];
                } else {
                    first = A[i + 1];
                    second = A[i];
                }

                if (first > second) {
                    return false;
                }
            }

            return true;
        }
    }


    @Test
    public void test(){

        boolean tmp = isMonotonic(new int[]{1,1,1,1,1,1});

    }
}
