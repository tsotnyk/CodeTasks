package com.j2core.sts.leetcode.com.valid.validMountainArray;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean validMountainArray(int[] A) {

        if (A.length < 3) return false;

        int index = 1;

        while (index < A.length){

            if (A[index] <= A[index-1]){

                if (index == 1){
                    return false;
                }else {
                    break;
                }
            }
            index++;
        }

        if (index == A.length) return false;

        while (index < A.length){

            if (A[index] >= A[index-1]){
                return false;
            }
            index++;
        }

        return true;
    }


    @Test
    public void test(){

        Assert.assertFalse(validMountainArray(new int[]{14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3}));

    }
}

