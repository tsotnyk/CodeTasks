package com.j2core.sts.leetcode.com.stringWithoutAAAOrBBB;

public class Solution {

    public String strWithout3a3b(int A, int B) {

        int amountSubstringA = A/2;
        if (A%2 != 0){
            amountSubstringA++;
        }

        int amountSubstringB = B/2;
        if (B%2 != 0){
            amountSubstringB++;
        }

        char first, second;
        int indexFirst, indexSecond;
        if (amountSubstringA >= amountSubstringB){
            first = 'a';
            second = 'b';
            indexFirst = A;
            indexSecond = B;
        }else {
            first = 'b';
            second = 'a';
            indexFirst = B;
            indexSecond = A;
        }

        StringBuilder builder = new StringBuilder();

        while (indexFirst > 0 && indexSecond > 0){

            builder.append(first);
            indexFirst--;
            if (indexFirst > 0){
                builder.append(first);
                indexFirst--;
            }
            builder.append(second);
            indexSecond--;
            if (indexSecond > 0){
                builder.append(second);
                indexSecond--;
            }
        }

        if (indexFirst > 0){
            while (indexFirst > 0){
                builder.append(first);
                indexFirst--;
            }
        }
        return builder.toString();
    }

    private String createString(char first, char second){


        return null;
    }
}
