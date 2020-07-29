package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_6 {

    public String compressionString(String string){

        if (string == null || string.length() < 2) return string;

        StringBuilder builder = new StringBuilder();

        char symbol = string.charAt(0);
        int counter = 1;

        for (int i = 1; i < string.length(); i++){

            if (string.charAt(i) != symbol){
                builder.append(symbol).append(counter);
                counter = 0;
                symbol = string.charAt(i);
            }

            counter++;
        }

        builder.append(symbol).append(counter);

        return string.length() < builder.length() ? string : builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(compressionString(null), null);
        Assert.assertEquals(compressionString(""), "");
        Assert.assertEquals(compressionString("q"), "q");
        Assert.assertEquals(compressionString("qq"), "q2");
        Assert.assertEquals(compressionString("aabcccccaaa"), "a2b1c5a3");
        Assert.assertEquals(compressionString("asdfghjkl"), "asdfghjkl");
        Assert.assertEquals(compressionString("aassddffgghhjjkkll"), "a2s2d2f2g2h2j2k2l2");

    }
}
