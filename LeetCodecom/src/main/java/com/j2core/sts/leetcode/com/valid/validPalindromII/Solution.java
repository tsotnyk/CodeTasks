package com.j2core.sts.leetcode.com.valid.validPalindromII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean validPalindromeOld(String s) {

        if (s == null || s.length() < 2) return true;
        return validPalindrome(s, 0, s.length()-1, false);
    }

    private boolean validPalindrome(String string, int indexStart, int indexEnd, boolean deleteAction){

        while (indexStart < indexEnd){

            if (string.charAt(indexStart) == string.charAt(indexEnd)){
                indexStart++;
                indexEnd--;
            }else {
                if (deleteAction) return false;
                if (validPalindrome(string, indexStart, indexEnd-1, true)) return true;
                return validPalindrome(string, indexStart+1, indexEnd, true);
            }
        }

        return true;
    }

    public boolean validPalindrome(String s) {

        if (s == null || s.length() < 2) return true;
        int delta = 0;
        int indexI = 0;
        int indexJ = s.length()-1;

        while (indexI < indexJ){
            if (delta == 0){
                if (s.charAt(indexI) != s.charAt(indexJ)){
                    delta++;
                }else {
                    indexI++;
                    indexJ--;
                }
            }else {
                if (indexI != indexJ-delta && indexJ != indexI+delta){
                    if (s.charAt(indexI) != s.charAt(indexJ-1) && s.charAt(indexI+1) != s.charAt(indexJ)) return false;
                }
                indexI++;
                indexJ--;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(validPalindrome("deeee"));

        Assert.assertTrue(validPalindrome("abca"));
        Assert.assertTrue(validPalindrome(""));
        Assert.assertTrue(validPalindrome("a"));
        Assert.assertTrue(validPalindrome(null));
        Assert.assertFalse(validPalindrome("acbda"));

    }
}
