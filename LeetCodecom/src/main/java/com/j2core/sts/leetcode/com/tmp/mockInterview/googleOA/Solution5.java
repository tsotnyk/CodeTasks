package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import org.junit.Assert;
import org.junit.Test;

public class Solution5 {


    public int lengthLongestPath(String input) {

        return 0;
    }


    public String licenseKeyFormatting(String S, int K) {

        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (int i = S.length()-1; i > -1; i--){
            char symbol = S.charAt(i);
            if (symbol != '-') {
                if (counter == K) {
                    builder.append('-');
                    counter = 0;
                }

                builder.append(Character.toUpperCase(symbol));
                counter++;
            }
        }

        return builder.reverse().toString();
    }

    @Test
    public void test(){

        Assert.assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
        Assert.assertEquals("AA-AA", licenseKeyFormatting("--a-a-a-a--", 2));

    }


}
