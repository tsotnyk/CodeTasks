package com.j2core.sts.leetcode.com.longestSubstringWithoutRepeatingCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

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


    @Test
    public void test(){

        int result = lengthOfLongestSubstring("dvdf");

        Assert.assertEquals(result, 3);
    }

}
