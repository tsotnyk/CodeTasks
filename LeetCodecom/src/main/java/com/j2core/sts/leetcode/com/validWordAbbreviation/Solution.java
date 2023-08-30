package com.j2core.sts.leetcode.com.validWordAbbreviation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean validWordAbbreviation(String word, String abbr) {

        int ind1 = 0;
        int ind2 = 0;
        int counter = 0;

        while (ind1 < word.length() && ind2 < abbr.length()){

            if (Character.isDigit(abbr.charAt(ind2))){
                counter = counter*10 + abbr.charAt(ind2)-'0';
                ind2++;
                continue;
            }
            if (counter > 0){
                ind1 += counter;
                counter = 0;
                continue;
            }
            if (word.charAt(ind1++) != abbr.charAt(ind2++)) return false;

        }

        return ind1+counter == word.length() && ind2 == abbr.length();

    }

    public boolean validWordAbbreviation1(String word, String abbr) {


        int i1 = 0;
        int i2 = 0;

        while (i2 < abbr.length() && i1 < word.length()){

            char symbol = abbr.charAt(i2);
            if (Character.isAlphabetic(symbol)){
                if (word.charAt(i1) != symbol) return false;
                i1++;
                i2++;
                continue;
            }
            if (symbol == '0') return false;
            int nextAlpha = i2+1;

            while (nextAlpha < abbr.length() && Character.isDigit(abbr.charAt(nextAlpha))){
                nextAlpha++;
            }

            int counter = Integer.parseInt(abbr.substring(i2, nextAlpha));

            i2 = nextAlpha;

            if (i1+counter > word.length()) return false;

            i1 += counter;
        }

        return i2 == abbr.length() && i1 == word.length();
    }

    @Test
    public void test(){

        Assert.assertTrue(validWordAbbreviation("a", "01"));

        Assert.assertFalse(validWordAbbreviation("hi", "2i"));
        Assert.assertTrue(validWordAbbreviation("internationalization", "i12iz4n"));
        Assert.assertFalse(validWordAbbreviation("APPLE", "A2E"));
        Assert.assertTrue(validWordAbbreviation("internationalization", "i5a11o1"));
    }

}
