package com.j2core.sts.leetcode.com.validWordAbbreviation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean validWordAbbreviation(String word, String abbr) {

        int num = 0;
        int iA = 0;
        int iW = 0;
        while (iA <= abbr.length() && iW < word.length()){
            if (iA == abbr.length()){
                iW += num;
                break;
            }
            if (Character.isDigit(abbr.charAt(iA))){
                if(abbr.charAt(iA) == '0' && num == 0) return false;
                num = num*10 + (abbr.charAt(iA)-'0');
                iA++;
            }else {
                if (num > 0){
                    iW += num;
                    num = 0;
                    continue;
                }
                if (word.charAt(iW) != abbr.charAt(iA)) return false;
                iA++;
                iW++;
            }
        }

        return iA == abbr.length() && iW == word.length();
    }

    @Test
    public void test(){

        Assert.assertTrue(validWordAbbreviation("internationalization", "i12iz4n"));
        Assert.assertFalse(validWordAbbreviation("apple", "a2e"));
        Assert.assertFalse(validWordAbbreviation("a", "2"));
        Assert.assertFalse(validWordAbbreviation("substitution", "s010n"));
    }
}
