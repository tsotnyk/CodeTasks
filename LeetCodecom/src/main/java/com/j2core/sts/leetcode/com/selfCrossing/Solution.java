package com.j2core.sts.leetcode.com.selfCrossing;

public class Solution {

    public boolean isSelfCrossing(int[] x) {
        int index, index0, index1, index2, index3;
        boolean up = false;

        if (x.length < 4) {
            return false;
        }

        index = 0;
        index0 = x[0];
        index1 = x[1];
        index2 = x[2];

        up = index0 < index2;

        for (int i = 3; i < x.length; i++) {
            index3 = x[i];

            if (!up && index3 >= index1) {
                return true;
            }
            else if (up && index3 <= index1) {
                if (index3 + index < index1 || (i + 1 < x.length && x[i + 1] + index0 < index2)) {
                    up = false;
                }
                else if (i + 1 < x.length) {
                    return true;
                }
            }

            index = index0;
            index0 = index1;
            index1 = index2;
            index2 = index3;
        }

        return false;
    }
}
