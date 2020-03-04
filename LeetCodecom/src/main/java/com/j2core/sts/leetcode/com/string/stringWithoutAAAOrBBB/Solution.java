package com.j2core.sts.leetcode.com.string.stringWithoutAAAOrBBB;

public class Solution {

    public String strWithout3a3b(int A, int B) {

        StringBuilder builder = new StringBuilder();

        builder = createString(A, B, builder);

        return builder.toString();
    }

    private StringBuilder createString(int A, int B, StringBuilder builder){

        if (A == 0 || B == 0){
            while (A != 0){
                builder.append("a");
                A--;
            }
            while (B != 0){
                builder.append("b");
                B--;
            }
            return builder;
        }

        if (A > B){
            builder.append("aab");
            return createString(A-2, B-1, builder);
        }else if (A == B){
            builder.append("ab");
            return createString(A-1, B-1, builder);
        }else {
            builder.append("bba");
            return createString(A-1, B-2, builder);
        }
    }

}
