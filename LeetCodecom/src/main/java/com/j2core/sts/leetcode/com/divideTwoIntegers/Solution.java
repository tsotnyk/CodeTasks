package com.j2core.sts.leetcode.com.divideTwoIntegers;

import org.junit.Test;
import org.testng.Assert;

public class Solution {

    public int divide(int dividend, int divisor) {

        if (divisor == 1) return dividend;

        if (dividend == divisor) return 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int result = 0;
        boolean negative;

        if (dividend > 0 && divisor > 0){
            negative = false;
        }else if (dividend < 0 && divisor < 0){
            negative = false;
            if (dividend == Integer.MIN_VALUE){
                dividend = (Integer.MAX_VALUE - divisor) + 1;
                result = 1;
            }
            dividend = Math.abs(dividend);
            divisor  = Math.abs(divisor);
        }else if (dividend < 0){

            if (dividend == Integer.MIN_VALUE){

                dividend = (Integer.MAX_VALUE - divisor) + 1;
                result = 1;

            }
            negative = true;
            dividend = Math.abs(dividend);
        }else {
            negative = true;
            divisor = Math.abs(divisor);
        }

//        while (dividend >= divisor){
//
//            result++;
//            dividend -= divisor;
//        }

        if (dividend < divisor) return 0;

        int sum = divisor;
        int countSum = 1;

        while (dividend-divisor >= sum){

            dividend -= divisor;
            result++;

            if (dividend-divisor >= sum){
                sum += divisor;
                countSum++;
            }

        }


        return negative ? (result+countSum)*-1 : result+countSum;
    }

    @Test
    public void test(){

        int result = divide(-2147483648, -1);

        Assert.assertEquals(result, 3);

    }

}
