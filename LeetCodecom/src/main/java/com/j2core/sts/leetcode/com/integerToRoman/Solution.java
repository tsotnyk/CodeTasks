package com.j2core.sts.leetcode.com.integerToRoman;

public class Solution {

    public String intToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < values.length; i++) {

            while(num >= values[i]) {
                num -= values[i];
                builder.append(letters[i]);
            }
        }
        return builder.toString();
    }
}
