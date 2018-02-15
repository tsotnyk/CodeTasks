package com.j2core.sts.leetcode.com.FindSmallestLetterGreaterThanTarget;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        char firstChar = letters[0];
        if (target >= letters[letters.length-1] || target < letters[0]) {
            return firstChar;
        }else {
            char result = firstChar;
            for (int i = 0; i < letters.length; i++) {

                char tmp = letters[i];
                if (target == tmp) {
                    result = letters[i+1];
                }else if (target < tmp){
                    result = tmp;
                    break;
                }
            }
            return result;
        }
    }
}
