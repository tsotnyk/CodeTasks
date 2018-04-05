package com.j2core.sts.codefights.com.firstRepeatingCharacter;

public class Solution {

    public char firstNotRepeatingCharacter(String s){

        int indexChar;

        for(int i = 0; i < s.length(); i++){

            indexChar  = s.indexOf(s.charAt(i));
            if (indexChar == i) {
                indexChar = s.substring(indexChar + 1).indexOf(s.charAt(i));
                if (indexChar < 0) return s.charAt(i);
            }
        }
        return '_';
    }

}
