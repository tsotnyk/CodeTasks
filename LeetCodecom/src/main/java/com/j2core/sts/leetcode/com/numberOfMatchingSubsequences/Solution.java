package com.j2core.sts.leetcode.com.numberOfMatchingSubsequences;

import java.util.Arrays;

public class Solution {

    public int numMatchingSubseq(String S, String[] words) {

        int counter = 0;

        for (String string : words){
            counter += isSubstring(S, string);
        }

        return counter;
    }

    private int isSubstring(String base, String substring){

        int baseLength = base.length();
        int length = substring.length();
        if (length > baseLength) return 0;
        int indexBase = 0;
        int index = 0;

        while (index < length && indexBase < baseLength){

            if (base.charAt(indexBase) == substring.charAt(index)){
                index++;
            }
            indexBase++;
        }

        return index == length ? 1 : 0;
    }
}
