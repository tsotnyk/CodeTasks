package com.j2core.sts.leetcode.com.plusOne;

import org.testng.annotations.Test;

public class Solution {

    public int[] plusOne(int[] digits) {

        if (digits.length < 1){
            return new int[]{1};
        }else {

            int newNum = 1;
            for (int i = digits.length-1; i > -1; i--){

                int num = digits[i] + newNum;

                if (num < 10){

                    digits[i] = num;
                    newNum = 0;
                    break;
                }else {

                    digits[i] = 0;

                }

            }

            if (newNum == 0){
                return digits;
            }else {

                int[] result = new int[digits.length+1];

                for (int k = digits.length; k > 0; k--){

                    result[k] = digits[k-1];

                }
                result[0] = newNum;

                return  result;

            }

        }
    }
}


