package com.j2core.sts.leetcode.com.uglyNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isUgly(int num) {

        if (num < 1) return false;

        if (num < 7) return true;

        while (num > 5){

            if (num%2 == 0){
                num = num / 2;
            }else if (num%3 == 0){
                num = num / 3;
            }else if (num%5 == 0){
                num = num / 5;
            }else {
                return false;
            }

        }

        return true;
    }


    @Test
    public void test(){

        boolean result = isUgly(63);

        Assert.assertTrue(result);

    }
}
