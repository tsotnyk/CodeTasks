package com.j2core.sts.leetcode.com.valid.validPalindrome;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int i = 0;
        int j = s.length()-1;

        while (i < j){
            char left = s.charAt(i);
            while (!Character.isAlphabetic(left) && !Character.isDigit(left)){
                i++;
                if (i == s.length()) return true;
                left = s.charAt(i);
            }
            char right = s.charAt(j);
            while (!Character.isAlphabetic(right) && !Character.isDigit(right)){
                j--;
                right = s.charAt(j);
            }
            if (left != right) return false;
            i++;
            j--;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome(",."));
        Assert.assertFalse(isPalindrome("0p"));

        Assert.assertTrue(isPalindrome(" "));
        Assert.assertTrue(isPalindrome(" A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));

    }
}
