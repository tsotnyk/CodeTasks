package com.j2core.sts.leetcode.com.buddyStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) return false;

        Map<Character, Integer> charMap = new HashMap<>();
        boolean swap = false;
        int index = -1;

        for (int i = 0; i < A.length(); i++){
            char symbol = A.charAt(i);
            charMap.put(symbol, charMap.getOrDefault(symbol, 0)+1);
            if (A.charAt(i) != B.charAt(i)){
                if (swap) return false;
                if (index == -1){
                    index = i;
                }else {
                    if (A.charAt(index) == B.charAt(i) && A.charAt(i) == B.charAt(index)){
                        swap = true;
                    }else {
                        return false;
                    }
                }
            }
        }

        if (swap) return true;
        if (index > -1) return false;
        for (Map.Entry<Character, Integer> counter : charMap.entrySet()){
            if (counter.getValue() > 1) return true;
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertFalse(buddyStrings("abac", "abad"));
        Assert.assertTrue(buddyStrings("ab", "ba"));
        Assert.assertTrue(buddyStrings("aa", "aa"));
        Assert.assertTrue(buddyStrings("aaaaabc", "aaaaacb"));
        Assert.assertFalse(buddyStrings("ab", "ab"));
        Assert.assertFalse(buddyStrings("", "aa"));
    }
}
