package com.j2core.sts.leetcode.com.addDigits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int addDigits(int num) {

        String number = String.valueOf(num);

        int result = num;

        while (result > 9) {
            int tmpResult = 0;

            for (int i = 0; i < number.length(); i++) {

                tmpResult += Integer.parseInt(String.valueOf(number.charAt(i)));

            }

            result = tmpResult;
            number = String.valueOf(result);
        }
        return result;
    }


    @Test
    public void test(){

        int result = addDigits(38);

        Assert.assertEquals(result, 2);

    }
}
