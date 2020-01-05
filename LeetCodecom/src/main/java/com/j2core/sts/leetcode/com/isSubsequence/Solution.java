package com.j2core.sts.leetcode.com.isSubsequence;

public class Solution {

    public boolean isSubsequence(String s, String t) {

        int baseLength = t.length();
        int length = s.length();
        int indexBase = 0;
        int index = 0;

        while (index < length && indexBase < baseLength){

            if (t.charAt(indexBase) == s.charAt(index)){
                index++;
            }
            indexBase++;
        }

        return index == length;
    }
}
