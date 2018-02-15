package com.j2core.sts.leetcode.com.FindTheDifference;

public class Solution {

    public char findTheDifference(String s, String t) {
        String big;
        String less;
        char result = 0;
        if (s.length() > t.length()){
            big = s;
            less = t;
        }else {
            less = s;
            big = t;
        }
        StringBuilder builder = new StringBuilder(less);
        for (int i = 0; i < big.length(); i++){
            char tmpChar = big.charAt(i);
            int index ;

            if (builder.toString().length() == 0){
                return tmpChar;
            }
            index = builder.indexOf(String.valueOf(tmpChar));
            if (index < 0) {
                return tmpChar;
            }
            builder.deleteCharAt(index);
        }
        return  result;
    }
}
