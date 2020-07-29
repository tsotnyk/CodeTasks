package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_5 {

    public boolean isOneActionChange(String string1, String string2){

        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;

        int delta = Math.abs(string1.length()-string2.length());

        if (delta > 1) return false;

        int[] symbols = new int[128];

        for (char symbol : string1.toCharArray()){
            symbols[(int) symbol] += 1;
        }
        for (char symbol : string2.toCharArray()){
            symbols[(int) symbol] -= 1;
        }
        int counter = 0;

        for (int sum : symbols) {
            counter += Math.abs(sum);
        }

        if (delta == 0){
            return counter <= 2;
        }
        return counter < 2;
    }

    @Test
    public void test(){

        Assert.assertTrue(isOneActionChange("",""));
        Assert.assertFalse(isOneActionChange(null, ""));
        Assert.assertFalse(isOneActionChange("", null));
        Assert.assertTrue(isOneActionChange(null, null));
        Assert.assertTrue(isOneActionChange("a", "a"));
        Assert.assertTrue(isOneActionChange("ab", "a"));
        Assert.assertTrue(isOneActionChange("bbb", "bbbc"));
        Assert.assertTrue(isOneActionChange("bbb", "cbb"));
        Assert.assertFalse(isOneActionChange("abcd", "zxcd"));
    }
}
