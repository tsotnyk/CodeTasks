package com.j2core.sts.leetcode.com.string.detectCapital;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean detectCapitalUse(String word) {

        if (word.length() < 2) return true;

        if (Character.isLowerCase(word.charAt(0))){
            return isLowCaseCharacters(word, 1);
        }else {
            if (Character.isLowerCase(word.charAt(1))){
                return isLowCaseCharacters(word, 2);
            }else {
                for (int i = 2; i < word.length(); i++){
                    if (Character.isLowerCase(word.charAt(i))) return false;
                }
            }
        }
        return true;
    }

    private boolean isLowCaseCharacters(String word, int index){

        for (int i = index ; i < word.length(); i++){
            if (Character.isUpperCase(word.charAt(i))) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(detectCapitalUse("L"));
        Assert.assertTrue(detectCapitalUse("l"));
        Assert.assertTrue(detectCapitalUse("leetcode"));
        Assert.assertTrue(detectCapitalUse("USA"));
        Assert.assertTrue(detectCapitalUse("Leetcode"));
        Assert.assertFalse(detectCapitalUse("fLAG"));
        Assert.assertFalse(detectCapitalUse("FlaG"));

    }
}
