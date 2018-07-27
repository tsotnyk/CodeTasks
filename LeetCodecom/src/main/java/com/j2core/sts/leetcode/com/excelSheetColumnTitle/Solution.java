package com.j2core.sts.leetcode.com.excelSheetColumnTitle;

public class Solution {

    public String convertToTitle(int n) {

        int number = 0;
        String letter = "";
        while(n > 0){

            number =(n-1) % 26;
            n = (n-1)/26;

            letter = letter + (char)(number + 65 );
        }

        String result = new StringBuilder(letter).reverse().toString();

        return result;
    }
}
