package com.j2core.sts.leetcode.com.numberComplement;

public class Solution {

    public int findComplement(int num) {
        String array = Integer.toBinaryString(num);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < array.length(); i++){

            char tmp = array.charAt(i);

            if (tmp == '0'){
                builder.append('1');
            }else {
                builder.append('0');
            }

        }

        return Integer.parseInt(builder.toString(), 2);
    }
}
