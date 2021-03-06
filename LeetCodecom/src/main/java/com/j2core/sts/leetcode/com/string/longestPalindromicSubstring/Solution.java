package com.j2core.sts.leetcode.com.string.longestPalindromicSubstring;

/*
   The class find the longest palindromic substring in basic string
 */
public class Solution {

    /**
     * The method find the longest palindromic substring in basic string
     *
     * @param s     basic string
     * @return      longest palindromic
     */
    public String longestPalindromeOld(String s) {

        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        char[] sArray = s.toCharArray();
        char[] newSArray = new char[(s.length()*2)];
        int index = 0;
        for (char aSArray : sArray) {

            newSArray[index++] = aSArray;
            newSArray[index++] = '|';

        }
        int pivotIndex = 0;
        int amountSteps = 0;
        int counter = 0;
        for (int j = 1; j < newSArray.length; j++){
            int delta = 1;
            while (j-delta > -1 && j+delta < newSArray.length){

                if (newSArray[j-delta] != newSArray[j+delta]){
                    break;
                }
                counter = delta;
                delta++;
            }
            if (counter > amountSteps){
                amountSteps = counter;
                pivotIndex = j;
            }

        }
        int amountChar = (amountSteps*2)+1;
        char[] arrayResult = new char[amountChar];

        System.arraycopy(newSArray, pivotIndex-amountSteps, arrayResult, 0, amountChar);

        StringBuilder result = new StringBuilder();
        for (char anArrayResult : arrayResult) {

            if (anArrayResult != '|') {
                result.append(anArrayResult);
            }
        }
        return result.toString();
    }

    public String longestPalindrome(String s) {

        int maxLength = 1;

        for (int i = 0; i < s.length(); ){

            int right = i-1;
            int left = i+1;

            while (left < s.length() && s.charAt(left) == s.charAt(i)){
                left++;
            }

            while (right > -1 && s.charAt(right) == s.charAt(i)){
                right--;
            }

            if (right == -1) {

            }
        }

        return null;
    }
}
