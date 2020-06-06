package com.j2core.sts.leetcode.com.longestSubstringWithoutRepeatingCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstringOld(String s) {

        if (s.length() < 1) {
            return 0;
        }

        int result = 1;

        for (int i = 0; i < s.length()-result; i++){

            Set<Character> set = new HashSet<>();
            int size;
            int index = i;
            do {
                size = set.size();
                if (index == s.length()){
                    break;
                }
                set.add(s.charAt(index++));

            }while (set.size() != size);

            if (size > result){
                result = size;
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        int maxLength = 1;
        int tmpLength = 0;
        int indexBack = 0;
        int[] alphabet = new int[128];

        for (int i = 0; i < s.length(); i++){
            char tmpChar = s.charAt(i);
            if (alphabet[tmpChar] == 0){
                alphabet[tmpChar] += 1;
                tmpLength++;
            }else {
                int index = s.lastIndexOf(tmpChar, i-1);
                maxLength = Math.max(maxLength, tmpLength);
                indexBack = Math.max(index, indexBack);
                tmpLength = i-indexBack;
            }
        }
        return Math.max(maxLength, tmpLength);
    }

    @Test
    public void test(){
        Assert.assertEquals(lengthOfLongestSubstring("abba"), 2);

        int result = lengthOfLongestSubstring("dvdf");

        Assert.assertEquals(result, 3);

        Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("bbbbbbbbbb"), 1);

    }

}
