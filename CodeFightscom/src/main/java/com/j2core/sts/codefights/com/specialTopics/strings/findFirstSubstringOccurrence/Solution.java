package com.j2core.sts.codefights.com.specialTopics.strings.findFirstSubstringOccurrence;

public class Solution {

    int findFirstSubstringOccurrence(String s, String x) {

        int lengthS = s.length();
        int lengthX = x.length();

        if (lengthX > lengthS) {
            return  -1;
        }else if (lengthX == lengthS){

            return s.equals(x) ? 0: -1;

        } else {

            for (int i = 0; i <= lengthS - lengthX; i++){

                if (s.charAt(i) == x.charAt(0)){

                    if (containString(s, x, i+lengthX-1, lengthX)){

                        return i;
                    }
                }
            }
            return -1;
        }
    }


    private boolean containString(String s, String x, int indexStart, int lengthX){

        int i, j;
        for (i = indexStart , j = lengthX-1; i > indexStart-lengthX; i--, j--){

            if (s.charAt(i) != x.charAt(j)){
                return false;
            }

        }
        return true;
    }
}
