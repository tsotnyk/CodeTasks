package com.j2core.sts.leetcode.com.swapAdjacentInLRString;

public class Solution {

    public boolean canTransform(String start, String end) {

        if (start.length() != end.length()) return false;
        int charR = 0;
        int charL = 0;

        for (int i = 0; i < start.length(); i++){
            char tmpStart = start.charAt(i);
            if (tmpStart == 'R'){
                charR++;
            }else if (tmpStart == 'L'){
                charL--;
            }
            char tmpEnd = end.charAt(i);
            if (tmpEnd == 'R'){
                charR--;
            }else if (tmpEnd == 'L'){
                charL++;
            }

            if (charL > 0 && charR > 0 || charL < 0 || charR < 0) return false;
        }

        return charL == 0 && charR == 0;
    }
}
