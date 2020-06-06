package com.j2core.sts.leetcode.com.string.reverseString;

public class Solution {

    public String reverseStringOld(String s) {

        StringBuilder builder = new StringBuilder();


        for (int i = s.length()-1; i > -1; i--){

            builder.append(s.charAt(i));
        }

        return builder.toString();

    }


    public void reverseString(char[] s) {

        int indexStart = 0;
        int indexEnd = s.length-1;

        while (indexStart < indexEnd){

            char tmp = s[indexStart];
            s[indexStart] = s[indexEnd];
            s[indexEnd] = tmp;
            indexStart++;
            indexEnd--;
        }
    }
}
