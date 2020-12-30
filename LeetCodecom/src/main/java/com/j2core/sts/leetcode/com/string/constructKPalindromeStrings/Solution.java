package com.j2core.sts.leetcode.com.string.constructKPalindromeStrings;

public class Solution {

    public boolean canConstruct(String s, int k) {

        if (s.length() < k) return false;
        if (s.length() == k) return true;

        int[] characters = new int[26];

        for (char symbol : s.toCharArray()){
            int index = symbol - 'a';
            characters[index] += 1;
        }

        for (int count : characters){
            if (count%2 != 0){
                k--;
            }
        }

        return k > -1;
    }
}
