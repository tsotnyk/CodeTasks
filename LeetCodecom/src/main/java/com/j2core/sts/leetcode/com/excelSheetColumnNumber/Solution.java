package com.j2core.sts.leetcode.com.excelSheetColumnNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int titleToNumber(String s) {

        int sum = 0;
        int delta = 1;

        for (int i = s.length()-1; i > -1; i--){

            int num = s.charAt(i) - 64;
            sum += num*delta;
            delta *= 26;
        }
        return sum;
    }

    @Test
    public void test(){

        int  tmp = titleToNumber("ZY");

        Assert.assertEquals(tmp , 701);

    }
}
