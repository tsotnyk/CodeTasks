package com.j2core.sts.leetcode.com.string.wordPattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {

        if (pattern.length() < 1) return false;

        Map<Character, String> patternMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < str.length(); ){

            int first = i;
            while (i < str.length() && str.charAt(i) != ' '){
                i++;
            }

            String tmp = str.substring(first, i);

            if (patternMap.containsKey(pattern.charAt(index))){

                if (!patternMap.get(pattern.charAt(index)).equals(tmp)){
                    return false;
                }

            }else {

                if (patternMap.containsValue(tmp)){
                    return false;
                }else {
                    patternMap.put(pattern.charAt(index), tmp);
                }
            }
            index++;
            i++;

            if ((index == pattern.length() && i < str.length()) || (i > str.length()-1 && index < pattern.length())){
                return false;
            }

        }

        return true;
    }


    @Test
    public void test(){

        boolean result = wordPattern("abba", "dog cat cat dog");

        Assert.assertTrue(result);

        boolean result1 = wordPattern("abba", "dog cat dog dog");

        Assert.assertFalse(result1);

        boolean result2 = wordPattern("aba", "cat cat cat dog");

        Assert.assertFalse(result1);

        boolean result3 = wordPattern("jquery", "jquery");

        Assert.assertFalse(result3);

    }
}
