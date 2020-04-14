package com.j2core.sts.leetcode.com.numberOfStepsToReduceNumberInBinaryRepresentationToOne;

import org.testng.annotations.Test;

public class Solution {

    public int numSteps(String s) {
        int res = 0;
        int add = 0;
        for (int i = s.length() - 1; i >= 1; i--) {  // last step will always be 1 step. (10 -> 1)
            if (s.charAt(i) - '0' + add == 1) {
                res += 2;
                add = 1;
            } else {
                res++;
                add = s.charAt(i) == '0' ? 0 : 1;
            }
        }
        return res + add;

    }

    @Test
    public void test(){

        System.out.println(numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
    }
}
