package com.j2core.sts.leetcode.com.validPalindrome;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPalindrome(String s) {

        int x = 0;
        int y = s.length()-1;
        String string = s.toLowerCase();

        while (x < y){

            if (!Character.isLetterOrDigit(string.charAt(x))){
                x++;
            }else if (! Character.isLetterOrDigit(string.charAt(y))){
                y--;
            }else {
                if (string.charAt(x) != string.charAt(y)){
                    return false;
                }
                x++;
                y--;
            }

        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertFalse(isPalindrome("0P"));
    }
}
