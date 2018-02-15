package com.j2core.sts.leetcode.com.ValidAnagram;

public class Solution {

    public boolean isAnagram(String s, String t) {
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
