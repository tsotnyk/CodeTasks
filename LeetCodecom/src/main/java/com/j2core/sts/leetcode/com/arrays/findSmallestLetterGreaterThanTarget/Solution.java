package com.j2core.sts.leetcode.com.arrays.findSmallestLetterGreaterThanTarget;

/*
The class find the smallest element in the list that is larger than the given target.
 */
public class Solution {

    /**
     * The method find the smallest element in the list that is larger than the given target
     *
     * @param letters     array with row letters
     * @param target      target's char
     * @return            smallest element in the list that is larger than the given target
     */
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
