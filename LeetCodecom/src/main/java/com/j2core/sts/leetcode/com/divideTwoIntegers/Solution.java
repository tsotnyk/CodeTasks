package com.j2core.sts.leetcode.com.divideTwoIntegers;

public class Solution {

    public int divide(int dividend, int divisor) {

        int result = 0, min = -2147483648, max = 2147483647;
        if(dividend == min && divisor == -1){
            return max;
        }
        boolean negative = true;
        if(dividend >= 0 && divisor > 0){
            dividend = 0 - dividend;
            divisor = 0 - divisor;
            negative = true;
        } else if(dividend >= 0 && divisor < 0){
            dividend = 0 - dividend;
            negative = false;
        } else if(dividend < 0 && divisor > 0){
            divisor = 0 - divisor;
            negative = false;
        }

        int bdivisor = divisor;
        while(dividend <= divisor){
            int i = 0;
            while(dividend <= divisor){
                int j = divisor;
                j <<= 1;
                if(dividend <= j && j<0){
                    divisor = j;
                    i++;
                }else{
                    break;
                }
            }
            result-=Math.pow(2,i);
            dividend = dividend - divisor;
            divisor = bdivisor;
        }

        return negative ? -result : result;

    }
}
