package com.j2core.sts.leetcode.com.uglyNumberIII;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long numA = a;
        long numB = b;
        long numC = c;
        long num = 0;

        while (n > 0){
            num = Math.min(numA, Math.min(numB,numC));
            if (numA == num){
                numA += a;
            }
            if (numB == num){
                numB += b;
            }
            if (numC == num){
                numC += c;
            }
            n--;
        }

        return (int)num;
    }


    public int nthUglyNumberTest(int n, int a, int b, int c) {

        int num = Math.min(a, b);
        num = Math.min(num, c);

        while (n != 1){
            num++;
            if (num %a == 0 || num %b == 0 || num %c == 0){
                n--;
            }
        }

        return num;
    }

    @Test
    public void test(){

        Assert.assertEquals(nthUglyNumberTest(131000, 2, 11, 13), 225698);
        Assert.assertEquals(nthUglyNumber(131000, 2, 11, 13), 225698);


        Assert.assertEquals(nthUglyNumber(20, 2, 11, 13), 34);
        Assert.assertEquals(nthUglyNumberTest(1000000000, 2, 217983653, 336916467), 1999999984);

        Assert.assertEquals(nthUglyNumber(1000000000, 2, 217983653, 336916467), 1999999984);
    }

}
