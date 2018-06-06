package com.j2core.sts.codefights.com.specialTopics.strings.amendTheSentence;

public class Solution {

    String amendTheSentence(String s) {

        StringBuilder newString = new StringBuilder();

        int startIndex = 0;

        for (int i = 0; i < s.length(); i++){

            if (Character.isUpperCase(s.charAt(i))){

                if (i > 0) {
                    newString.append(s.substring(startIndex, i).toLowerCase()).append(' ');
                    startIndex = i;
                }
            }
        }

        if (startIndex < s.length()){

            newString.append(s.substring(startIndex).toLowerCase());
        }

        return newString.toString();
    }

}
