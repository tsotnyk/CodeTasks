package com.j2core.sts.leetcode.com.string.rotateString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean rotateString(String A, String B) {


        if (A.length() != B.length()) return false;
        if (A.length() == 0) return true;

        int index = B.indexOf(A.charAt(0));
        int indexFirstChar = index;

        while (index > -1) {
            boolean result = true;

            for (int i = 1; i < A.length(); i++) {

                index++;
                if (index == A.length()) {
                    index = 0;
                }

                if (A.charAt(i) != B.charAt(index)) {
                    result = false;
                    break;
                }

            }

            if (result) return true;
            if (indexFirstChar + 1 < A.length()) {
                index = B.indexOf(A.charAt(0), indexFirstChar + 1);
                if (index > 0){
                    indexFirstChar = index;
                }
            }else index = -1;
        }


        return false;
    }


    @Test
    public void test(){

        boolean result = rotateString("ohbrwzxvxe",
                "uornhegseo");

        Assert.assertFalse(result);

    }

}
