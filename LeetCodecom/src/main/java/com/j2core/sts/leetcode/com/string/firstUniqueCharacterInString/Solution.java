package com.j2core.sts.leetcode.com.string.firstUniqueCharacterInString;

/*
  The class find the first non-repeating character in it and return it's index.
 */
public class Solution {

    /**
     * The method find the first non-repeating character in it and return it's index.
     *
     * @param s       basic string
     * @return        first non-repeating character's index or -1
     */
    public int firstUniqChar(String s) {
        int result = -1;

        for (int i = 0; i < s.length(); i++){

            char tmp = s.charAt(i);
            if (s.lastIndexOf(tmp) == i && s.indexOf(tmp) == i){
                result = i;
                break;
            }
            while (i < s.length()-1 && tmp == s.charAt(i+1)){
                i++;
            }

        }

        return result;
    }
}
