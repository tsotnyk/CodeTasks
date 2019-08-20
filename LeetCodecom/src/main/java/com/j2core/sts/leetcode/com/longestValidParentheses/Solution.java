package com.j2core.sts.leetcode.com.longestValidParentheses;

public class Solution {

    public int longestValidParentheses(String s) {

        char[] symbols = findCorrectPairs(s);
        int length = s.length();

        int result = 0;
        int tmpResult = 0;
        int index = 0;

        while (index < length){
            if (symbols[index++] != '1'){
                if (tmpResult != 0 && result < tmpResult){
                    result = tmpResult;
                }
                tmpResult = 0;
            }else {
                tmpResult++;
            }
        }

        return result < tmpResult ? tmpResult : result;
    }

    private char[] findCorrectPairs(String s){

        char[] symbols = s.toCharArray();
        int length = s.length();
        int index = s.length()-1;

        while (index > -1){

            while (index > -1 && symbols[index] != '('){
                index--;
            }

            if (index < 0){
                break;
            }

            int secondIndex = index+1;

            while (secondIndex < length && symbols[secondIndex] != ')'){
                secondIndex++;
            }

            if (secondIndex < length){
                symbols[index] = '1';
                symbols[secondIndex] = '1';
            }

            index--;
        }
        return symbols;
    }
}
