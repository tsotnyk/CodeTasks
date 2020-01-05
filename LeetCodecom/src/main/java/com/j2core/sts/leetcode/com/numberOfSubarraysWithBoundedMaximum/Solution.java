package com.j2core.sts.leetcode.com.numberOfSubarraysWithBoundedMaximum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        long smaller = L;
        long bigger = R;
        int indexLast = A.length - 1;
        int index = A.length - 1;
        int counter = 0;
        long sum = A[indexLast];

        while (indexLast > -1) {

            index--;
            if (sum < smaller && index > -1) {
                sum += A[index];
            } else if (sum >= smaller && sum < bigger) {
                counter++;
                if (index > -1) {
                    sum += A[index];
                } else {
                    break;
                }
            } else {
                if (sum == bigger) {
                    counter++;
                }
                indexLast--;
                index = indexLast;
                sum = A[indexLast];
            }
        }

        return counter;
    }

    public int numSubarrayBoundedMax1(int[] A, int L, int R) {

        int counter = 0;
        int preIndex = -1;
        int preCountre = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < L) {
                counter += preCountre;
            } else if (A[i] > R) {
                preIndex = i;
                preCountre = 0;
            } else {
                preCountre = i - preIndex;
                counter += preCountre;
            }
        }
        return counter;
}

    @Test
    public void test(){

//        Assert.assertEquals(numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3), 3);
        Assert.assertEquals(numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8), 7);

    }
}
