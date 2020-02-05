package com.j2core.sts.leetcode.com.stringWithoutAAAOrBBB;

public class Solution {

    public String strWithout3a3b(int A, int B) {

        StringBuilder builder = new StringBuilder();

        if (A == 0 || B == 0){
            while (A != 0){
                builder.append("a");
                A--;
            }
            while (B != 0){
                builder.append("b");
                B--;
            }
            return builder.toString();
        }

        if (A > B){
            builder.append("aab");
            return builder.append(strWithout3a3b(A-2, B-1)).toString();
        }else if (A == B){
            builder.append("ab");
            return builder.append(strWithout3a3b(A-1, B-1)).toString();
        }else {
            builder.append("bba");
            return builder.append(strWithout3a3b(A-1, B-2)).toString();
        }
    }

}
