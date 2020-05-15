package com.j2core.sts.leetcode.com.string.longestSubstringWithAtMostTwoDistinctCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if (s == null || s.length() < 1) return 0;
        if (s.length() < 3) return s.length();

        int maxLength = 0;
        int index1 = 0;
        int index2 = 0;
        int index = index1+1;

        while (index < s.length()){
            if (s.charAt(index) != s.charAt(index1)){
                if (index1 == index2){
                    index2 = index;
                }else if (s.charAt(index2) != s.charAt(index)){
                    maxLength = Math.max(maxLength, index-index1);
                    index1 = index2;
                    index = index1;
                }
            }
            index++;
        }

        return Math.max(maxLength, index-index1);
    }

    @Test
    public void test(){

        Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("abaccc"), 4);

        Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("ccaabbb"), 5);


    }
}
