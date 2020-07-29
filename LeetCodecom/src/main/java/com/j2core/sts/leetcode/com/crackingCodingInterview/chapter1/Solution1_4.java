package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_4 {

    public boolean isPalindromePermutation(String string){

        if (string == null || string.length() < 2) return true;
        int[] symbols = new int[128];

        string = string.toLowerCase();

        for (char symbol : string.toCharArray()){
            if (Character.isAlphabetic(symbol)){
                symbols[(int) symbol] += 1;
                symbols[(int) symbol] %= 2;
            }
        }

        int counter = 0;

        for (int symbolSum : symbols){
            if (symbolSum > 0){
                counter++;
                if (counter > 1) return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindromePermutation(null));
        Assert.assertTrue(isPalindromePermutation(""));
        Assert.assertTrue(isPalindromePermutation("a"));
        Assert.assertTrue(isPalindromePermutation("aa"));
        Assert.assertTrue(isPalindromePermutation("Tact Coa"));
        Assert.assertTrue(isPalindromePermutation("Tact Coa!"));

        Assert.assertFalse(isPalindromePermutation("null"));
    }
}
