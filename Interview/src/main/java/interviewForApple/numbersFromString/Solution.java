package com.j2core.sts.leetcode.com.numbersFromString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPattern(String string){

        int length = string.length();
        for (int i = 1; i < length; i++) {

            for (int j = 0; j < i; j++) {

                long firstElement = Long.parseLong(string.substring(0, j+1));
                long secondElement = Long.parseLong(string.substring(j + 1, i + 1));

                if (secondElement >= firstElement) {

                    StringBuilder builder = new StringBuilder();

                    builder.append(firstElement).append(secondElement);

                    while (builder.length() < length){

                        long sum = firstElement + secondElement;
                        builder.append(sum);
                        firstElement = secondElement;
                        secondElement = sum;
                    }
                    if (string.equals(builder.toString())){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Test
    public void test(){

        boolean result1 = isPattern("1112233558");
        boolean result2 = isPattern("1101102203");
        boolean result3 = isPattern("224610");

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);

    }
}
