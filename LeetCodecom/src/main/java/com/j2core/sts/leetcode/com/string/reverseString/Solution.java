package com.j2core.sts.leetcode.com.string.reverseString;

public class Solution {

    public String reverseString(String s) {

        StringBuilder builder = new StringBuilder();


        for (int i = s.length()-1; i > -1; i--){

            builder.append(s.charAt(i));
        }

        return builder.toString();

    }
}
