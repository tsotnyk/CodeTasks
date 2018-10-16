package com.j2core.sts.leetcode.com.sortArrayByParityII;

import org.testng.annotations.Test;

public class Solution {

    public int[] sortArrayByParityII(int[] A) {

        int[] newArray = new int[A.length];

        int i = 0;
        int j = A.length-1;
        int index = 0;

        while (index < A.length){

            while (A[i] %2 != 0){
                i++;
            }

            newArray[index++] = A[i++];

            while (A[j] %2 == 0){
                j--;
            }

            newArray[index++] = A[j--];

        }

        return newArray;

    }

    @Test

    public void test(){

        int[] result = sortArrayByParityII(new int[]{4,2,5,7});

    }


}
