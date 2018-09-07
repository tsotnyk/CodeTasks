package com.j2core.sts.leetcode.com.licenseKeyFormatting;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String licenseKeyFormatting(String S, int K) {

        String string = S.toUpperCase();
        string = string.replaceAll("-", "");

        StringBuilder builder = new StringBuilder();

        int index = 0;
        int countChar = string.length()%K;

        while (index < string.length()){

            if (countChar == 0){
                if (index > 0) builder.append('-');
                countChar = K;
            }
            builder.append(string.charAt(index));
            countChar--;
            index++;
        }

        return builder.toString();
    }


    @Test
    public void test(){

        String result = licenseKeyFormatting("5F3Z-2e-9-w", 4);

        Assert.assertEquals(result, "5F3Z-2E9W");


    }



}
