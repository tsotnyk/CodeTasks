package com.j2core.sts.leetcode.com.string.reverseWordsInStringIII;

public class Solution {

    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        int stopIndex;

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == ' '){

                stopIndex = i;
                createNewString(s, result, startIndex, stopIndex);
                result.append(' ');
                startIndex = stopIndex + 1;

            }
        }

        if (startIndex < s.length()){

            createNewString(s, result, startIndex, s.length());
        }

        return result.toString();

    }


    private void createNewString(String s, StringBuilder newString, int startIndex, int stopIndex){

        for (int i = stopIndex-1; i >= startIndex; i--){

            newString.append(s.charAt(i));
        }

    }
}
