package com.j2core.sts.leetcode.com.valid.validPalindromII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while (left <= right){
            if (s.charAt(left)!= s.charAt(right)){
                if (isPalindrome(left+1, right, s)) return true;
                return isPalindrome(left, right-1, s);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(int left, int right, String s){

        while (left <= right){
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(validPalindrome("aba"));
        Assert.assertTrue(validPalindrome("abca"));
        Assert.assertFalse(validPalindrome("abc"));
    }
}
