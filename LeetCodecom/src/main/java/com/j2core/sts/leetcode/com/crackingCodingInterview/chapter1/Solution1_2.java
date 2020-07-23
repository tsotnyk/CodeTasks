package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_2 {

    public boolean isPermutation(String baseString, String permutationString){

        if (baseString == null && permutationString == null) return true;
        if (baseString == null || permutationString == null) return false;
        if (baseString.length() != permutationString.length()) return false;

        int[] symbols = new int[128];

        for (char symbol : baseString.toCharArray()){
            symbols[(int) symbol] += 1;
        }

        for (char symbol : permutationString.toCharArray()){
            if (symbols[(int) symbol] == 0) return false;
            symbols[(int) symbol] -= 1;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPermutation(null, null));
        Assert.assertTrue(isPermutation("null", "null"));
        Assert.assertTrue(isPermutation("aaaaaa", "aaaaaa"));
        Assert.assertTrue(isPermutation("aaabbb", "abbbaa"));
        Assert.assertTrue(isPermutation("asdf", "asdf"));
        Assert.assertTrue(isPermutation("asdf", "asdf"));
        Assert.assertTrue(isPermutation("asdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopzxcvbnm",
                "lkjhgfdsamnbvcxzpoiuytrewqlkjhgfdsaqwertyuiopzxcvbnm"));


        Assert.assertFalse(isPermutation(null, "s"));
        Assert.assertFalse(isPermutation("hdfhd", null));
        Assert.assertFalse(isPermutation("hdgdfdgg", ""));
        Assert.assertFalse(isPermutation("", "sdfhhh"));
        Assert.assertFalse(isPermutation("null", "gs"));
        Assert.assertFalse(isPermutation("aab", "ssa"));
        Assert.assertFalse(isPermutation("aab", "bas"));

    }
}
