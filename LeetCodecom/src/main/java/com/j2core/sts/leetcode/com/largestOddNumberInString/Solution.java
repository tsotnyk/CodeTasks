package com.j2core.sts.leetcode.com.largestOddNumberInString;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public String largestOddNumber(String num) {

        HashSet<Character> oddNumber = new HashSet<>(Arrays.asList('1', '3', '5', '7', '9'));

        int index = num.length()-1;

        while (index > -1 && !oddNumber.contains(num.charAt(index))){
            index--;
        }

        return index == -1 ? "" : num.substring(0, index+1);
    }

    @Test
    public void test(){

        Assert.assertEquals("5", largestOddNumber("52"));
        Assert.assertEquals("", largestOddNumber("4206"));
        Assert.assertEquals("35427", largestOddNumber("35427"));

    }
}
