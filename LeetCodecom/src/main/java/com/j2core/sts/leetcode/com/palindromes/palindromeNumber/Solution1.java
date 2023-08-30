package com.j2core.sts.leetcode.com.palindromes.palindromeNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean isPalindromeWithString(int x) {

        if (x < 0) return false;
        String  num = String.valueOf(x);

        int i = 0;
        int j = num.length()-1;

        while (i < j){
            if (num.charAt(i++) != num.charAt(j--)) return false;
        }

        return true;
    }

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int num = x;
        int newNum = num%10;
        num /= 10;
        while (num > 0){
            newNum = (newNum * 10) + num%10;
            num = num/10;
        }

        return newNum == x;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome(121));
    }
}
