package com.j2core.sts.leetcode.com.string.findTheDifference;

/*
 The class find the letter that was added in second string.
 */
public class Solution {

    /**
     * The method find the letter that was added in changed string.
     *
     * @param s    basic string
     * @param t    changed string
     * @return     char witch added in to second string
     */
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
