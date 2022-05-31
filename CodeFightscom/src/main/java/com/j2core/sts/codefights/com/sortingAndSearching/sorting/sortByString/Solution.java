package com.j2core.sts.codefights.com.sortingAndSearching.sorting.sortByString;

public class Solution {

    String sortByString(String s, String t) {

        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS < 2 || lengthT < 1){
            return s;
        }else {

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < lengthT; i++){

                char tmpChar = t.charAt(i);

                for (int j = 0; j < lengthS; j++){

                    if (s.charAt(j) == tmpChar){
                        builder.append(s.charAt(j));
                    }
                }
            }

            return builder.toString();

        }
    }
}
