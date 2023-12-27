package com.j2core.sts.leetcode.com.string.reverseWordsInString;

public class Solution1 {

    public String reverseWords(String s) {

        StringBuilder builder = new StringBuilder();

        String[] wordArray = s.split(" ");

        for (String word : wordArray){
            if (word.length() > 0){
                builder.insert(0, word);
                builder.insert(0, " ");
            }
        }

        builder.delete(0, 1);

        return builder.toString();
    }
}
