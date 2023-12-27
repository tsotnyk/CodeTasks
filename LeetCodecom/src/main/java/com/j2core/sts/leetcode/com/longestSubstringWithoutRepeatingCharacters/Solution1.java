package com.j2core.sts.leetcode.com.longestSubstringWithoutRepeatingCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return s.length();

        HashSet<Character> symSet = new HashSet<>();

        int iS = 0;
        int iE = 0;

        int maxSubstring = 1;

        while (iE < s.length()){
            if (symSet.contains(s.charAt(iE))){
                while (s.charAt(iS) != s.charAt(iE)){
                    symSet.remove(s.charAt(iS));
                    iS++;
                }
                iS++;
            }else {
                symSet.add(s.charAt(iE));
                maxSubstring = Math.max(maxSubstring, symSet.size());
            }
            iE++;
        }

        return maxSubstring;
    }

    @Test
    public void test(){

        Assert.assertEquals(lengthOfLongestSubstring("aabaab!bb"), 3);
    }
}
