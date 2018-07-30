package com.j2core.sts.leetcode.com.string.toLowerCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String toLowerCase(String str) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++){

            int numChar = str.charAt(i);

            if (numChar > 64 && numChar < 91) {
                int newNumChar = numChar + 32;
                char tmp = (char) newNumChar;

                builder.append(tmp);
            }else {
                builder.append(str.charAt(i));
            }
        }

        return builder.toString();
    }


    @Test
    public void test(){

        String result = toLowerCase("Hello");

        Assert.assertTrue(result.equals("hello"));

    }

}
