package com.j2core.sts.leetcode.com.string.jewelsAndStones;

public class Solution {

    public int numJewelsInStones(String J, String S) {

        if (J.length() < 1 || S.length() < 1) return 0;

        int result = 0;

        for (int i = 0; i < J.length(); i++){

            char jewel = J.charAt(i);

            for (int j = 0; j < S.length(); j++){

                if (S.charAt(j) == jewel){

                    result++;

                }
            }
        }

        return result;

    }

}
