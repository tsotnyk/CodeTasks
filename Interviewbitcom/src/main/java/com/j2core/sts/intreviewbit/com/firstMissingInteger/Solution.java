package com.j2core.sts.intreviewbit.com.firstMissingInteger;

import java.util.Arrays;

public class Solution {

    public int firstMissingPositive(int[] A) {

        Arrays.sort(A);
        int result = 1;
        for (int num : A){

            if (num > 0){

                if (result == num){
                    result++;
                }else return result;

            }
        }
        return result;
    }
}
