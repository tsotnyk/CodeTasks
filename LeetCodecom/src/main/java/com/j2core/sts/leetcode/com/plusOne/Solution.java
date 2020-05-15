package com.j2core.sts.leetcode.com.plusOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int[] plusOneOld(int[] digits) {

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

    public int[] plusOne(int[] digits) {

        int delta = 1;
        for (int i = digits.length-1; i > -1; i--){

            int sum = digits[i]+delta;
            delta = 0;
            if (sum > 9){
                delta = sum/10;
                sum %= 10;
            }
            digits[i] = sum;

            if (delta == 0) break;
        }

        if (delta > 0){
            int[] newArray = new int[digits.length+1];
            newArray[0] = delta;
            System.arraycopy(newArray, 1, digits, 0, digits.length);
            return newArray;
        }

        return digits;
    }

    @Test
    public void test(){

        int[] result = plusOne(new int[]{9});
        Assert.assertEquals(result.length, 2);
    }
}


