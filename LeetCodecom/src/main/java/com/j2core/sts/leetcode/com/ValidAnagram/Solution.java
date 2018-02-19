package com.j2core.sts.leetcode.com.ValidAnagram;

/*
   The class check determine if first string is an anagram of second string
 */
public class Solution {

    /**
     * The method check determine if first string is an anagram of second string
     *
     * @param t     first string
     * @param s     second string
     * @return      first string is anagram of second string or not
     */
    public boolean isAnagram(String t, String s) {
        if (s.length() != t.length()) return false;

        int amountLetterS;
        int amountLetterT;
        int index;
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (s.substring(0, i).indexOf(letter) < 0) {
                amountLetterS = 0;
                amountLetterT = 0;
                index = -1;
                int tmpIndex;
                while (index < length) {
                    tmpIndex = s.indexOf(letter, index + 1);
                    if (tmpIndex > -1) {
                        amountLetterS++;
                        index = tmpIndex;
                    } else break;
                }
                index = -1;
                while (index < length) {
                    tmpIndex = t.indexOf(letter, index + 1);
                    if (tmpIndex > -1) {
                        amountLetterT++;
                        index = tmpIndex;
                    } else break;
                }
                if (amountLetterS != amountLetterT) return false;
            }
        }

        return true;
    }
}
