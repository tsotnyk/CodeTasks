package com.j2core.sts.leetcode.com.string.repeatedStringMatch;

/*
   The class find the minimum number of times basic string has to be repeated such that string is a substring of it
 */
public class Solution {

    /**
     * The method find the minimum number of times basic string has to be repeated such that string is a substring of it
     *
     * @param A      basic string
     * @param B      subString
     * @return       amount repeated basic string
     */
    public int repeatedStringMatch(String A, String B) {

        int result = -1;
        int lengthA = A.length();
        int lengthB = B.length();
        String tmp = A;
        if(lengthA != 0 && lengthB > 0){

            if (lengthB > lengthA){
                int match = lengthB/lengthA;
                if (lengthA * match < lengthB){
                    match = match + 1;
                }
                int index = 1;
                StringBuilder builder = new StringBuilder();
                builder.append(tmp);
                while (index < match){
                    builder.append(A);
                    index++;
                }
                tmp = builder.toString();
                if (tmp.contains(B)){
                    result = match;
                }else {

                    tmp = tmp+A;
                    if (tmp.contains(B)){
                        result = match+1;
                    }
                }
            }else {

                if (A.contains(B)){
                    result = 1;
                }else{

                    tmp = tmp + A;
                    if (tmp.contains(B)){
                        result = 2;
                    }
                }
            }
        }

        return result;
    }
}
